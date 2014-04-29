package com.aythia.fripouille.world.objects;

/**
 * Created on 29/04/2014.
 */
public class WorldObject {
    public static final String EMPTY_CELL = "";
    private final String object;

    public WorldObject() {
        this.object = EMPTY_CELL;
    }

    public WorldObject(String object) {
        this.object = object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorldObject that = (WorldObject) o;

        return !(object != null ? !object.equals(that.object) : that.object != null);

    }

    @Override
    public int hashCode() {
        return object != null ? object.hashCode() : 0;
    }
}
