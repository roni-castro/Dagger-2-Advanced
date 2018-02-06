package com.hariofspades.dagger2advanced.components;

import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;
import com.hariofspades.dagger2advanced.modules.RandomUserModule;

import dagger.Component;

/**
 * Created by roni on 06/02/18.
 */
@Component(modules = {RandomUserModule.class})
public interface RandomUserComponent {

    RandomUsersApi getRandomUserService();
}
