package com.hariofspades.dagger2advanced.interfaces;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


import javax.inject.Scope;

/**
 * Created by roni on 06/02/18.
 */
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface RandomUserSingletonScope {

}
