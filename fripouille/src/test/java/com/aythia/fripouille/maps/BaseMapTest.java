package com.aythia.fripouille.maps;

/**
 * Created on 29/04/2014.
 */

import com.aythia.fripouille.world.objects.WorldObject;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;


public class BaseMapTest {
    @Test
    public void emptyMap() {
        Map emptyMap = new Map();
        assertThat(0).isEqualTo(emptyMap.numberLines());
        assertThat(0).isEqualTo(emptyMap.numberColumns());

    }

    @Test
    public void noCellInMap() {
        Map noCellMap = new Map(5, 10);
        assertThat(5).isEqualTo(noCellMap.numberLines());
        assertThat(10).isEqualTo(noCellMap.numberColumns());
        assertThat(noCellMap.getCell(2, 9)).isNull();
    }
    @Test
    public void setCellInMap() {
        Map smallestMap = new Map(1, 1);
        smallestMap.setCell(0, 0, new WorldObject());
        assertThat(smallestMap.getCell(0, 0)).isNotNull();
    }

}
