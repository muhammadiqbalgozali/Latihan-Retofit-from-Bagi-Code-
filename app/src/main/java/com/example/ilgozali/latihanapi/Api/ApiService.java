package com.example.ilgozali.latihanapi.Api;

import com.example.ilgozali.latihanapi.Model.ModelData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    //membuat Service Api untuk mengambil data menggunakan GET(ambil)
    @GET("list_data.php")
    Call<List<ModelData>> getAllData();

}
