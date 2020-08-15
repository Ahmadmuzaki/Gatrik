package com.ahmadmuzaki.gatrik.Model;

//DataModel adalah setter dan getter untuk datanya seperti id, nama, alamat, trip, tanggal berangkat
public class DataModel {
    private int id;
    String nama, alamat, no_hp, trip, tgl_brangkat, jam_brangkat, jml_book;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public String getTgl_brangkat() {
        return tgl_brangkat;
    }

    public void setTgl_brangkat(String tgl_brangkat) {
        this.tgl_brangkat = tgl_brangkat;
    }

    public String getJam_brangkat() {
        return jam_brangkat;
    }

    public void setJam_brangkat(String jam_brangkat) {
        this.jam_brangkat = jam_brangkat;
    }

    public String getJml_book() {
        return jml_book;
    }

    public void setJml_book(String jml_book) {
        this.jml_book = jml_book;
    }
}
