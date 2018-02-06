package com.hariofspades.dagger2advanced.components;

import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by roni on 06/02/18.
 */
@Component
public interface RandomUserComponent  {
    RandomUsersApi getRandomUserService();
    Picasso getPicasso();
}
