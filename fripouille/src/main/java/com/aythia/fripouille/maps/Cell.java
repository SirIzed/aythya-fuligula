package com.aythia.fripouille.maps;

import com.aythia.fripouille.world.objects.WorldObject;

import java.util.Arrays;

/**
 * Created on 29/04/2014.
 */

public class Cell {
    WorldObject[] content;

    public Cell() {
        this.content = new WorldObject[]{};
    }

    public Cell(WorldObject[] content) {
        this.content = Arrays.copyOf(content, content.length);

    }

    public WorldObject getVisible() {
        return content[0];
    }
}
