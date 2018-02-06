package com.hariofspades.dagger2advanced;

import com.hariofspades.dagger2advanced.components.DaggerRandomUserComponent;
import com.hariofspades.dagger2advanced.components.RandomUserComponent;
import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by roni on 06/02/18.
 */

public class ComponentScopeTest {
    @Test
    public void testIfRandomUserModuleIsASingleton() {
        RandomUserComponent randomUserComponent =
                DaggerRandomUserComponent.builder().build();
        Assert.assertEquals(
                randomUserComponent.getRandomUserService().hashCode(),
                randomUserComponent.getRandomUserService().hashCode());
    }
}
