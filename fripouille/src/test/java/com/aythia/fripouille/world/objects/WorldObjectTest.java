package com.aythia.fripouille.world.objects;

import org.fest.assertions.api.Assertions;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created on 29/04/2014.
 */
public class WorldObjectTest {
    @Test
    public void baseComparisons() {
        Assertions.assertThat(new WorldObject()).isEqualTo(new WorldObject());
        Assertions.assertThat(new WorldObject("X")).isEqualTo(new WorldObject("X"));
        Assertions.assertThat(new WorldObject("X")).isNotEqualTo(new WorldObject("Y"));

    }
}
