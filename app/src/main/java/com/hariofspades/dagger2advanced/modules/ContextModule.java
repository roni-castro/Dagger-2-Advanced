package com.hariofspades.dagger2advanced.modules;

import android.content.Context;

import com.hariofspades.dagger2advanced.interfaces.ApplicationContext;
import com.hariofspades.dagger2advanced.interfaces.RandomUserSingletonScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by roni on 06/02/18.
 */

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @RandomUserSingletonScope
    @Provides
    @ApplicationContext
    public Context context(){
        return context.getApplicationContext();
    }
}