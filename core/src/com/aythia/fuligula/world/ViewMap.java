package com.aythia.fuligula.world;

import com.aythia.fripouille.maps.Map;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created on 29/04/2014.
 */
public class ViewMap extends Actor {
    private Map map;
    private static int cellHeight;
    private static int cellWidth;
    BitmapFont font;

    public ViewMap(Map map) {
        this.map = map;
        createFont();
        cellHeight = 15;
        cellWidth = 15;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(1, 1, 1, parentAlpha);
        for (int line = map.numberLines() - 1 ; line >= 0 ; line-- ) {
            for (int column = 0 ; column < map.numberColumns() ; column++) {
                int x = column * cellWidth;
                int y = (map.numberLines() - 1 - line) * cellHeight;
                font.draw(batch, map.getCell(line, column).getType(), x, y);
            }
        }
    }

    private void createFont() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("courier.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 12;

        font = generator.generateFont(parameter);
        generator.dispose();

    }

}
