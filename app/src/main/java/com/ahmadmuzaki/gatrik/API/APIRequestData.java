package com.ahmadmuzaki.gatrik.API;

import com.ahmadmuzaki.gatrik.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

//Digunakan untuk menghubungkan android dengan webservice
public interface APIRequestData {
    @GET("ambilData.php")
//    pesan data dan data sudah didaftarkan pada ResponModel -- ARD = API Request Data
    Call<ResponseModel> ardAmbilData();

}
