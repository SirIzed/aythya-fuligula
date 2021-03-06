package com.aythia.fripouille.maps.generate;

import com.aythia.fripouille.maps.Cell;
import com.aythia.fripouille.maps.Map;
import com.aythia.fripouille.world.objects.WorldObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;

/**
 * Created on 29/04/2014.
 */
public class Generate {

    public Map fromArrayNode(ArrayNode jsonMap) {
        ArrayList<ArrayList<Cell>> cells = getArrayListsFromArrayNode(jsonMap);

        return mapFromNotEmptyMap(cells);

    }

    private ArrayList<ArrayList<Cell>> getArrayListsFromArrayNode(ArrayNode mapArray) {

        ArrayList<ArrayList<Cell>> cellMap = new ArrayList<>();
        CheckIntegrity integrity = new CheckIntegrity();

        for (JsonNode line : mapArray) {
            String lineString = line.asText();
            integrity.onNewLine(lineString);
            cellMap.add(getLineFromString(line.asText()));
        }
        integrity.hadLine();
        return cellMap;
    }

    private ArrayList<Cell> getLineFromString(String stringLine) {
        ArrayList<Cell> lineCell = new ArrayList<>();
        for (int index = 0 ; index < stringLine.length() ; index++) {
            lineCell.add(new WorldObject(Character.toString(stringLine.charAt(index))));
        }

        return lineCell;
    }

    private static Map mapFromNotEmptyMap(ArrayList<ArrayList<Cell>> cells) {
        int numberLines = cells.size();
        int numberColumns = cells.get(0).size();
        Map map = new Map(numberLines, numberColumns);

        for (int line = 0 ; line < numberLines ; line++) {
            for (int column = 0 ; column < numberColumns ; column++) {
                map.setCell(line, column, cells.get(line).get(column));
            }
        }
        return map;
    }
}
