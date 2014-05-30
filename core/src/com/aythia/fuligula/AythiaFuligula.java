package com.aythia.fuligula;

import com.aythia.fripouille.maps.Map;
import com.aythia.fuligula.world.ViewMap;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class AythiaFuligula extends ApplicationAdapter {
	private static Stage stage;
    private static Gui gui;

	@Override
	public void create () {
        stage = new Stage(new ScreenViewport());

        Gdx.input.setInputProcessor(stage);
        gui = new Gui(stage);
        stage.addActor(new ViewMap(Map.fromArrayNode(loadNodeFromFilename("/smiley.json"))));
	}

	@Override
	public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void resize (int width, int height) {
        stage.getViewport().update(width, height, true);
    }

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

}
