package com.example.ilgozali.latihanapi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelData {
//membuat model data yang diambil dari databasenya gunakan pojo untuk mempermudah dalam memanggil dari Json
@SerializedName("id_costummer")
@Expose
private String idCostummer;
    @SerializedName("mulai")
    @Expose
    private String mulai;
    @SerializedName("selesai")
    @Expose
    private String selesai;
    @SerializedName("status_table")
    @Expose
    private String statusTable;
    //memanggil fungsi data
    public static final String id_costummer = "ID_COSTUMMER";
    public static final String waktu_mulai = "ID_COSTUMMER";
    public static final String Waktu_selesai = "ID_COSTUMMER";
    public static final String status_costummer = "ID_COSTUMMER";


    public ModelData(String id, String waktumulai, String waktuselesai, String status) {
        this.idCostummer = id;
        this.mulai = waktumulai;
        this.selesai = waktuselesai;
        this.statusTable = status;
    }

    public String getIdCostummer() {
        return idCostummer;
    }

    public void setIdCostummer(String idCostummer) {
        this.idCostummer = idCostummer;
    }

    public String getMulai() {
        return mulai;
    }

    public void setMulai(String mulai) {
        this.mulai = mulai;
    }

    public String getSelesai() {
        return selesai;
    }

    public void setSelesai(String selesai) {
        this.selesai = selesai;
    }

    public String getStatusTable() {
        return statusTable;
    }

    public void setStatusTable(String statusTable) {
        this.statusTable = statusTable;
    }


}
