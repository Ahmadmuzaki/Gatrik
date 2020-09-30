package com.ahmadmuzaki.gatrik.API;

import com.ahmadmuzaki.gatrik.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APICreateData {

    @FormUrlEncoded
    @POST("tambahDataGatrik.php")
    Call<ResponseModel> simpan(
        @Field("nama") String nama,
        @Field("alamat") String alamat,
        @Field("no_hp") String no_hp,
        @Field("trip") String trip,
        @Field("tgl_brangkat") String tgl_brangkat,
        @Field("jam_brangkat") String jam_brangkat,
        @Field("jml_book") String jml_book
    );
}
