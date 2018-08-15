package com.example.pentil.hexavara;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText et_username,et_password;
    private Button btn_login;
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
                    }
                    break;
            }
        }
    };

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
        btn_login = (Button)findViewById(R.id.login);
    }
}
