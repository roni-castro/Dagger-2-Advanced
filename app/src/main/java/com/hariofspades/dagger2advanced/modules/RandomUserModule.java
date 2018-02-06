package com.hariofspades.dagger2advanced.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by roni on 06/02/18.
 */

@Module(includes = OkHttpClientModule.class)
public class RandomUserModule {
    private static final String BASE_URL = "https://randomuser.me/";

    @Provides
    public RandomUsersApi getRandomUserService(Retrofit retrofit){
        return retrofit.create(RandomUsersApi.class);
    }

    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    public Gson gson(){
        return new GsonBuilder().create();
    }
}
