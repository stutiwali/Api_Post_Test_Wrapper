package com.example.api_post_test2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;
    private static final String BASEURL="http://kgamifytest-env.eba-sb353hxm.ap-south-1.elasticbeanstalk.com/app/login";

    public static Retrofit getRetrofit() {


        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}

