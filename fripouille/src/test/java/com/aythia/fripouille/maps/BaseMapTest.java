package com.aythia.fripouille.maps;

/**
 * Created on 29/04/2014.
 */

import com.aythia.fripouille.world.objects.WorldObject;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class BaseMapTest {
    @Test
    public void emptyMap() {
        Map emptyMap = new Map();
        assertThat(0, is(emptyMap.numberLines()));
        assertThat(0, is(emptyMap.numberColumns()));
    }

    @Test
    public void noCellInMap() {
        Map noCellMap = new Map(5, 10);
        assertThat(5, is(noCellMap.numberLines()));
        assertThat(10, is(noCellMap.numberColumns()));
        assertThat(noCellMap.getCell(2, 9), is(nullValue()));
    }
    @Test
    public void setCellInMap() {
        Map smallestMap = new Map(1, 1);
        smallestMap.setCell(0, 0, new WorldObject());
        assertThat(smallestMap.getCell(0, 0), is(notNullValue()));

    }

}
