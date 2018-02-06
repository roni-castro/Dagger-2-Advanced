package com.hariofspades.dagger2advanced.components;

import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;
import com.hariofspades.dagger2advanced.modules.PicassoModule;
import com.hariofspades.dagger2advanced.modules.RandomUserModule;
import com.hariofspades.dagger2advanced.interfaces.RandomUserSingletonScope;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by roni on 06/02/18.
 */
@RandomUserSingletonScope
@Component(modules = {RandomUserModule.class, PicassoModule.class})
public interface RandomUserComponent {

    RandomUsersApi getRandomUserService();

    Picasso getPicasso();
}
