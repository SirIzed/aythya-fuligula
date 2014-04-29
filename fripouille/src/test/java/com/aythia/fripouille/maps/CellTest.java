package com.aythia.fripouille.maps;

import com.aythia.fripouille.world.objects.WorldObject;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created on 29/04/2014.
 */
public class CellTest {

    @Rule public ExpectedException thrown = ExpectedException.none();

    @Test
    public void emptyCellThrowExceptionOnVisible() {
        thrown.expect(ArrayIndexOutOfBoundsException.class);

        Cell emptyCell = new Cell();
        emptyCell.getVisible();
    }

    @Test
    public void getVisible() {
        WorldObject character = new WorldObject("@");
        WorldObject floor = new WorldObject(".");
        Cell aCell = new Cell(new WorldObject[]{character, floor});
        assertThat(aCell.getVisible(), is(sameInstance(character)));
    }
}
