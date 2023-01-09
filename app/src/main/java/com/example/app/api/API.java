package com.example.app.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API {

    @FormUrlEncoded
    @POST("createUser")
    Call<ResponseBody> createUser
            (
            @Field("ID") String ID,
            @Field("Email") String Email,
            @Field("isUser") String isUser,
            @Field("LettersNum") String LettersNum
    );
}
