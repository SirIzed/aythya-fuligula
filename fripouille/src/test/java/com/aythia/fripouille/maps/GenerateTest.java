package com.aythia.fripouille.maps;

import com.aythia.fripouille.world.objects.WorldObject;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created on 29/04/2014.
 */
public class GenerateTest {
    private ArrayNode loadNodeFromFilename(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode mapNode = null;
        try {
            mapNode = (ObjectNode) objectMapper.readTree(getClass().getResourceAsStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert mapNode != null;
        return (ArrayNode) mapNode.get("map");
    }

    @Test
    public void fromJsonNode()  {
        Map map = Map.fromArrayNode(loadNodeFromFilename("/raw_map.json"));

        assertThat(map.getCell(0, 0), CoreMatchers.<Cell>equalTo(new WorldObject("X")));
        assertThat(map.getCell(2, 4), CoreMatchers.<Cell>equalTo(new WorldObject("Y")));
    }

    @Rule public ExpectedException thrown = ExpectedException.none();

    @Test
    public void checkIntegrityNoLine() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("No line found");
        Map.fromArrayNode(loadNodeFromFilename("/raw_map_no_map.json"));
    }

    @Test
    public void checkIntegrityEmptyLine() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Empty line");
        Map.fromArrayNode(loadNodeFromFilename("/raw_map_empty_line.json"));
    }

    @Test
    public void checkIntegrityDifferentLineSize() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("two different line size");
        Map.fromArrayNode(loadNodeFromFilename("/raw_map_different_line_size.json"));
    }

}
