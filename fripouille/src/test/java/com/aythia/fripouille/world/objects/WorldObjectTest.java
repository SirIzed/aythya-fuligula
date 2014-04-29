package com.aythia.fripouille.world.objects;

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
        assertThat(new WorldObject(), is(new WorldObject()));
        assertThat(new WorldObject("X"), is(new WorldObject("X")));
        assertThat(new WorldObject("X"), is(not(new WorldObject("Y"))));
    }
}
