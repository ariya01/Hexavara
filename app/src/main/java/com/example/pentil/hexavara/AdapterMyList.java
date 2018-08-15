package com.example.pentil.hexavara;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Pentil on 16/08/2018.
 */

public class AdapterMyList extends RecyclerView.Adapter<AdapterMyList.AdapterHolder> {
    private List<PojoMylist> mylist;
    private int rowLayout;
    private Context context;
    @Override
    public AdapterMyList.AdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterMyList.AdapterHolder holder, int position) {
        holder.tv_nama.setText(mylist.get(position).getName());
        holder.tv_gaji.setText(mylist.get(position).getSalary());
        Glide.with(context).load("http://"+mylist.get(position).getImage().replaceAll("\\\\","")).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        private TextView tv_nama,tv_gaji;
        private ImageView imageView;
        public AdapterHolder(View itemView) {
            super(itemView);
            tv_nama = (TextView)itemView.findViewById(R.id.nama_rc);
            tv_gaji = (TextView)itemView.findViewById(R.id.gaji_rc);
            imageView = (ImageView)itemView.findViewById(R.id.image_rc);
        }
    }

    public AdapterMyList (List<PojoMylist> mylist, int rowLayout,Context context)
    {
        this.mylist=mylist;
        this.rowLayout=rowLayout;
        this.context = context;
    }
}
