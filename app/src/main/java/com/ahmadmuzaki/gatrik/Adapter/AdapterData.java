package com.ahmadmuzaki.gatrik.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadmuzaki.gatrik.Model.DataModel;
import com.ahmadmuzaki.gatrik.R;

import java.util.List;

//Adapter Data berfungsi untuk Mengalirkan Data dari database ke cardview
//Class AdapterData akan diturunkan dari RecycleView.Adapter yang membutuhkan VH(ViewHolder)
//Jika Error makan pilih implement Method dan pilih 3 method tambahan
public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{
    //Menyiapkan constructor
    //Context = wakil activity di class non activity
    private Context ctx;
    private List<DataModel> listPenumpang;

    public AdapterData(Context ctx, List<DataModel> listPenumpang) {
        this.ctx = ctx;
        this.listPenumpang = listPenumpang;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate ke card data penumpang, parent sebagai root
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_data_penumpang, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        //Memanggil Data Model
        //Posision akan menyetel posisi data pertama untuk card pertama data kedua untuk card kedua dan seterusnya
        DataModel dataModel = listPenumpang.get(position);
        //Karena Id memiliki type Int dan setText menghendaki String maka data int diubah menjadi String
        holder.textViewId.setText(String.valueOf(dataModel.getId()));
        holder.textViewNama.setText(dataModel.getNama());
        holder.textViewAlamat.setText(dataModel.getAlamat());
        holder.textViewTrip.setText(dataModel.getTrip());
    }

    @Override
    public int getItemCount() {
        return listPenumpang.size();
    }

    //Membuat class di dalam class, catatan hanya boleh ada 1 kelas public dalam 1 file java
    //HolderData digunakan untuk menghandle cardview
    public class HolderData extends RecyclerView.ViewHolder{
        TextView textViewId, textViewNama, textViewAlamat, textViewTrip;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            //findViewById tidak bisa langsung. Harus ijin dulu lewat cardviewyo
            //R tidak berfungsi karena dalam projek ini saya membuat package sendiri
            textViewId = itemView.findViewById(R.id.text_view_id);
            textViewNama = itemView.findViewById(R.id.text_view_nama);
            textViewAlamat = itemView.findViewById(R.id.text_view_alamat);
            textViewTrip = itemView.findViewById(R.id.text_view_trip);
        }
    }
}
