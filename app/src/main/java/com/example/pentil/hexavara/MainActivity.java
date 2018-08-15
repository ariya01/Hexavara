package com.example.pentil.hexavara;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView tv_namalengkap,tv_username,tv_email,tv_alamat;
    private de.hdodenhof.circleimageview.CircleImageView circleImageView;
    private RecyclerView recyclerView;
    private List<PojoMylist> item;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        deklarasi();
        tv_namalengkap.setText(SessionUser.getFullname());
        tv_username.setText(SessionUser.getUsername());
        tv_email.setText(SessionUser.getEmail());
        tv_alamat.setText(SessionUser.getAddress());
        Glide.with(this).load(SessionUser.getPhoto()).into(circleImageView);
        getrecycler();
    }

    private void getrecycler()
    {
        APIService apiService = new APIService();
        apiService.mylist(SessionUser.getToken(), new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                item = (List<PojoMylist>) response.body();
                linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                AdapterMyList adapterMyList = new AdapterMyList(item,R.layout.item_rc,getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapterMyList);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void deklarasi()
    {
        tv_namalengkap = (TextView)findViewById(R.id.nama_lengkap);
        tv_username = (TextView)findViewById(R.id.username);
        tv_email = (TextView)findViewById(R.id.email);
        tv_alamat = (TextView)findViewById(R.id.alamat);
        circleImageView = (de.hdodenhof.circleimageview.CircleImageView)findViewById(R.id.cir_user);
        recyclerView = (RecyclerView)findViewById(R.id.rc_view);
    }
}
