package com.hariofspades.dagger2advanced;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.hariofspades.dagger2advanced.components.DaggerRandomUserComponent;
import com.hariofspades.dagger2advanced.components.RandomUserComponent;
import com.hariofspades.dagger2advanced.modules.ContextModule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class RandomUserContextModuleTest {

    private RandomUserComponent randomUserComponent;

    @Before
    public void setUp(){
        Context appContext = InstrumentationRegistry.getTargetContext();
        randomUserComponent = DaggerRandomUserComponent.builder()
                .contextModule(new ContextModule(appContext))
                .build();
    }

    @Test
    public void testIfRandomUserModulesAreSingleton() {

        Assert.assertEquals(
                randomUserComponent.getRandomUserService().hashCode(),
                randomUserComponent.getRandomUserService().hashCode());
    }

    @Test
    public void  testIfPicassoModuleIsASingleton() {
        Assert.assertEquals(
                randomUserComponent.getPicasso(),
                randomUserComponent.getPicasso());
    }
}
