package com.aythia.fripouille.maps;

import com.aythia.fripouille.world.objects.WorldObject;
import com.fasterxml.jackson.databind.node.ArrayNode;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.fest.assertions.api.Assertions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;


/**
 * Created on 29/04/2014.
 */
public class GenerateTest {
    private ArrayNode loadNodeFromFilename(String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        ObjectNode mapNode = (ObjectNode) objectMapper.readTree(getClass().getResourceAsStream(filename));

        return (ArrayNode) mapNode.get("map");
    }

    @Test
    public void fromJsonNode() throws IOException {
        Map map = Map.fromArrayNode(loadNodeFromFilename("/raw_map.json"));

        Assertions.assertThat(map.getCell(0, 0)).isEqualTo(new WorldObject("X"));
        Assertions.assertThat(map.getCell(2, 4)).isEqualTo(new WorldObject("Y"));
    }

    @Rule public ExpectedException thrown = ExpectedException.none();

    @Test
    public void checkIntegrityNoLine() throws IOException {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("No line found");

        Map.fromArrayNode(loadNodeFromFilename("/raw_map_no_map.json"));
    }

    @Test
    public void checkIntegrityEmptyLine() throws IOException {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Empty line");

        Map.fromArrayNode(loadNodeFromFilename("/raw_map_empty_line.json"));
    }

    @Test
    public void checkIntegrityDifferentLineSize() throws IOException {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("two different line size");

        Map.fromArrayNode(loadNodeFromFilename("/raw_map_different_line_size.json"));
    }

}
