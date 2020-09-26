package com.ahmadmuzaki.gatrik.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Membuat koneksi ke server melalui retrofit
//Memmiliki isi
//Base Url
public class RetroServer {
    private static final String baseURL = "http://ahmadmuzaki.xyz/api/";
    private static Retrofit retro;

    //Converter factory digunakan untuk menerjemahkan data json yang akan dikenali oleh android
//    retro == null adalah jika koneksi retro belum terbangun/terbentuk maka build baseurl dengan converterfactory
    public static Retrofit konekRetrofit() {
        if (retro == null) {
            retro = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }
}
