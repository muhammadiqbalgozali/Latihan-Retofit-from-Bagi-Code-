package com.example.ilgozali.latihanapi.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ilgozali.latihanapi.Model.ModelData;
import com.example.ilgozali.latihanapi.R;

import java.util.ArrayList;

public class ListArrayAdapter extends ArrayAdapter<ModelData> {
    //adapter untuk mengambil data pada class model
    private ArrayList<ModelData> list;
    private LayoutInflater inflater;
    private int res;

    public ListArrayAdapter(Context context, int resource, ArrayList<ModelData> list) {
        super(context, resource, list);
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        MyHolder holder = null;


        if (convertView == null) {

            convertView = inflater.inflate(res, parent, false);

            holder = new MyHolder();

            holder.ID_costummer = (TextView) convertView.findViewById(R.id.tx_customer);
            holder.Waktu_Mulai = (TextView) convertView.findViewById(R.id.tx_mulai);
            holder.Waktu_Selesai = (TextView) convertView.findViewById(R.id.tx_selesai);
            holder.Status = (TextView) convertView.findViewById(R.id.tx_status);

            convertView.setTag(holder);

        } else {

            holder = (MyHolder) convertView.getTag();
        }

        holder.ID_costummer.setText(list.get(position).getIdCostummer());
        holder.Waktu_Mulai.setText( list.get(position).getMulai());
        holder.Waktu_Selesai.setText( list.get(position).getSelesai());
        holder.Status.setText( list.get(position).getStatusTable());

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void remove(ModelData object) {

        super.remove(object);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    static class MyHolder {

        TextView ID_costummer;
        TextView Waktu_Mulai;
        TextView Waktu_Selesai;
        TextView Status;

    }
}
