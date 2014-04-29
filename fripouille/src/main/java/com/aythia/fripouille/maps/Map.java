/**
 * Created on 28/04/2014.
 */

package com.aythia.fripouille.maps;

import com.aythia.fripouille.maps.generate.Generate;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class Map {
    private Cell[][] map;

    public Map() {
        map = new Cell[][] {};
    }
    public Map(int numberLines, int numberColumns) {
        map = new Cell[numberLines][numberColumns];
    }

    public static Map fromArrayNode(ArrayNode jsonMap) {
        return new Generate().fromArrayNode(jsonMap);
    }

    public int numberLines() {
        return map.length;
    }
    public int numberColumns() {
        return map.length > 0 ? map[0].length : 0;
    }

    public Cell getCell(int line, int column) {
        return map[line][column];
    }

    public void setCell(int line, int column, Cell cell) {
        map[line][column] = cell;
    }
}
