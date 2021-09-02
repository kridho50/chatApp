package com.example.messagetest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("{id}/Messages")
    Call<GetChatMassage> getListChat(@Path("id") String id,
                                     @Query("token") String token, @Query("phone") String phone);

    @POST("{id}/sendMessage")
    Call<ChatMassage> sendMassage(@Path("id") String id, @Query("token")String token,
                                  @Body SendMassage body);

}
