package com.example.api_post_test2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    @POST("")
    Call<LoginsWrapper> createPost(@Body LoginsWrapper loginsWrapper);
}
