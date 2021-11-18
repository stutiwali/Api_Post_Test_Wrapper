package com.example.api_post_test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    Api api;

    List<Logins> login_arr;

    EditText phone,country,imei;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        onClickActivity();

    }

    private void onClickActivity() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phone.getText().toString().isEmpty() && country.getText().toString().isEmpty() && imei.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                    return;
                }

                postData( phone.getText().toString(),country.getText().toString(),imei.getText().toString());

            }
        });
    }

    private void postData(String phone2,String country2,String imei2) {

        Logins logins=new Logins(phone2,country2,imei2);
        List<Logins> logins_arr_post=new ArrayList<>();
        logins_arr_post.add(logins);
        setDataToApi(logins_arr_post);
        // Toast.makeText(getApplicationContext(),phone2+"=="+country2+"=="+imei2,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"Old one="+logins_arr_post.get(0).getPhone(),Toast.LENGTH_LONG).show();





    }

    private void setDataToApi(List<Logins> logins_arr_post) {

        api=RetrofitInstance.getRetrofit().create(Api.class);
        LoginsWrapper loginWrapper=new LoginsWrapper(logins_arr_post);
        Toast.makeText(MainActivity.this, "new one="+loginWrapper.getLogins().get(0).getPhone(), Toast.LENGTH_SHORT).show();
        //  Toast.makeText(getApplicationContext(),"New one="+loginWrapper.getLogins().get(0).getPhone(),Toast.LENGTH_LONG).show();
        Call<LoginsWrapper> call=api.createPost(loginWrapper);
        call.enqueue(new Callback<LoginsWrapper>() {
            @Override
            public void onResponse(Call<LoginsWrapper> call, Response<LoginsWrapper> response) {
                Toast.makeText(MainActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                phone.setText("");
                country.setText("");
                imei.setText("");

                login_arr=response.body().getLogins();
                String str="Ph="+login_arr.get(3).getPhone()+"\nCode="+login_arr.get(3).getCountry_code()+"\nImei="+login_arr.get(3).getImei();


            }

            @Override
            public void onFailure(Call<LoginsWrapper> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error found :"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void initialize() {

        phone=(EditText) findViewById(R.id.phone);
        country=(EditText) findViewById(R.id.country);
        imei=(EditText) findViewById(R.id.imei);
    }
}