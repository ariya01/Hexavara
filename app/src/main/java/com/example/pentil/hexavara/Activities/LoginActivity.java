package com.example.pentil.hexavara.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.pentil.hexavara.API.APIService;
import com.example.pentil.hexavara.Pojo.PojoLogin;
import com.example.pentil.hexavara.R;
import com.example.pentil.hexavara.Session.SessionUser;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText et_username,et_password;
    private CardView btn_login;
    private ProgressDialog progressDialog;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        deklarasi();
        btn_login.setOnClickListener(action);
    }

    private View.OnClickListener action = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Boolean bool;
            switch (v.getId())
            {
                case R.id.login:
                    bool=validasi();
                    if (bool==true)
                    {
                        setprogressbar();
                        login();
                    }
                    break;
            }
        }
    };

    private void login()
    {
        APIService apiService = new APIService();
        apiService.login(et_username.getText().toString(), et_password.getText().toString(), new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.message().equals("OK"))
                {
                    PojoLogin pojoLogin = (PojoLogin)response.body();
                    SessionUser.setToken(pojoLogin.getToken());
                    SessionUser.setUsername(pojoLogin.getUsername());
                    SessionUser.setEmail(pojoLogin.getEmail());
                    SessionUser.setFullname(pojoLogin.getFullname());
                    SessionUser.setAddress(pojoLogin.getAddress());
                    String foto ="http://"+pojoLogin.getPhoto().replaceAll("\\\\","");
                    SessionUser.setPhoto(foto);
                    intent =  new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    hideprogressbar();
                }
                else
                {
                    try {
                        String error = response.errorBody().string();
                        hideprogressbar();
                        Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                        hideprogressbar();
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private boolean validasi()
    {

        int jumlahusername = 0;
        int jumlahpassword =0;
        for (int i = 0; i < et_username.getText().toString().length(); i++)
            jumlahusername++;
        for (int i = 0; i < et_password.getText().toString().length(); i++)
            jumlahpassword++;

        if (jumlahpassword==0)
        {
            et_password.setError("Password tidak boleh kosong");
        }
        else if (jumlahpassword<6)
        {
            et_password.setError("Password minimal 6");
        }
        if (jumlahusername==0)
        {
            et_username.setError("Username tidak boleh kosong");
        }

        if (jumlahpassword>=6&&jumlahusername>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void deklarasi()
    {
        et_username = (EditText)findViewById(R.id.username);
        et_password = (EditText)findViewById(R.id.password);
        btn_login = (CardView) findViewById(R.id.login);
    }

    private void setprogressbar()
    {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Authentication");
        progressDialog.setMessage("Loading");
        progressDialog.show();
    }

    private void hideprogressbar()
    {
        progressDialog.dismiss();
    }
}
