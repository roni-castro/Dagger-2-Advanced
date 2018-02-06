package com.hariofspades.dagger2advanced;

import android.content.Context;

import com.hariofspades.dagger2advanced.components.DaggerRandomUserComponent;
import com.hariofspades.dagger2advanced.components.RandomUserComponent;
import com.hariofspades.dagger2advanced.modules.ContextModule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
/**
 * Created by roni on 06/02/18.
 */

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class ComponentScopeTest {
    @Mock
    private Context context;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkIfRandomUserModulesAreSingleton() {
        RandomUserComponent randomUserComponent =
                DaggerRandomUserComponent.builder()
                        .contextModule(new ContextModule(context))
                        .build();
        Assert.assertEquals(
                randomUserComponent.getRandomUserService(),
                randomUserComponent.getRandomUserService());
    }
}
