package com.aythia.fripouille.world.objects;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created on 29/04/2014.
 */
public class WorldObjectTest {
    @Test
    public void baseComparisons() {
        assertThat(new WorldObject()).isEqualTo(new WorldObject());
        assertThat(new WorldObject("X")).isEqualTo(new WorldObject("X"));
        assertThat(new WorldObject("X")).isNotEqualTo(new WorldObject("Y"));

    }
}
