package com.example.ilgozali.latihanapi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ilgozali.latihanapi.Adapter.ListArrayAdapter;
import com.example.ilgozali.latihanapi.Api.ApiService;
import com.example.ilgozali.latihanapi.Model.ModelData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DaftarMahasiswa extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //definisikan array list yang di daptkan pada class model data
    ArrayList<ModelData> modelDataMahasiswa = new ArrayList<ModelData>();

    //mendefinisikan object yang akan di panggil
    ListView listView;
    ListArrayAdapter listArrayAdapter;

    LinearLayout layout_loading;
    TextView tv_load;
    ImageView img_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_mahasiswa);

        //panggil object menjadi suatu fungsi
        layout_loading = findViewById(R.id.liner_loading);

        tv_load = findViewById(R.id.text_load);
        img_load = findViewById(R.id.icon_load);

        listView = findViewById(R.id.list_mhs);

        //membuat fungsi listview menjadi bisa di klik
      listView.setOnItemClickListener((AdapterView.OnItemClickListener) DaftarMahasiswa.this);
        listView.setDividerHeight(0);
        setup();



    }

    private void setup() {
        //fungsi retofit untuk membaca Gson
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //memanggil Api
        ApiService apiService = retrofit.create(ApiService.class);

        //panggil ke list Model data
        Call<List<ModelData>> call = apiService.getAllData();
        call.enqueue(new Callback<List<ModelData>>() {
            @Override
            public void onResponse(Call<List<ModelData>> call, Response<List<ModelData>> response) {
                if (response.isSuccessful()){
                    int jumlah = response.body().size();

                    for (int i = 0; i < jumlah; i++){
                        ModelData data = new ModelData(
                                response.body().get(i).getIdCostummer(),
                                response.body().get(i).getMulai(),
                                response.body().get(i).getSelesai(),
                                response.body().get(i).getStatusTable()
                        );
                        //objek list akan mengambil data yang ada di model
                        modelDataMahasiswa.add(data);
                        //mengetes Bug untuk data masuk
                        Log.d("Respon", "onRespon :" + response.body().size());
                    }
                    listView.setVisibility(View.VISIBLE);
                    listArrayAdapter = new ListArrayAdapter(DaftarMahasiswa.this, R.layout.row_mahasiswa,modelDataMahasiswa);
                    listView.setAdapter(listArrayAdapter);

                    if (listArrayAdapter.getCount() < 1 ) {
                        layout_loading.setVisibility(View.VISIBLE);
                        String error = "Daftar mahasiswa Kosong";
                        tv_load.setText(error);
                        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_data_kosong);
                        img_load.setImageBitmap(icon);
                    } else {
                        layout_loading.setVisibility(View.GONE);
                    }
                } else {
                    String error = "Error Retrive Data from Server !!!";
                    tv_load.setText(error);
                    Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_network);
                    img_load.setImageBitmap(icon);
                }
            }

            @Override
            public void onFailure(Call<List<ModelData>> call, Throwable t) {
                String error = "Error Retrive Data from Server wwaau!!!\n" + t.getMessage();
                tv_load.setText(error);
                Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_network);
                img_load.setImageBitmap(icon);

            }
        });
    }

    @Override
   public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            listArrayAdapter.clear();
            setup();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}

