package com.hariofspades.dagger2advanced.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;
import com.hariofspades.dagger2advanced.interfaces.RandomUserSingletonScope;

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
    @RandomUserSingletonScope
    public RandomUsersApi getRandomUserService(Retrofit retrofit){
        return retrofit.create(RandomUsersApi.class);
    }

    @RandomUserSingletonScope
    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, Gson gson){
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    @RandomUserSingletonScope
    public Gson gson(){
        return new GsonBuilder().create();
    }

    @Provides
    @RandomUserSingletonScope
    public GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }
}
