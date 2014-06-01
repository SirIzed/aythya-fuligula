package com.aythia.fuligula.libgdx.ui;

import com.aythia.fuligula.libgdx.listener.CloseListener;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created on 30/05/2014.
 */
public class Window extends com.badlogic.gdx.scenes.scene2d.ui.Window {
    TextButton closeButton;
    public Window(String title, Skin skin) {
        super(title, skin);
        padTop((float) (1.2 * getStyle().titleFont.getLineHeight()));
        addMenuButton(skin);
    }

    private void addMenuButton(Skin skin) {
        closeButton = new TextButton("X", skin);
        closeButton.addListener(new CloseListener(this));
        addActor(closeButton);
    }

    protected void drawBackground (Batch batch, float parentAlpha, float x, float y) {
        super.drawBackground(batch, parentAlpha, x, y);
        closeButton.setPosition(x + getPadLeft(), y + getHeight() - closeButton.getHeight());
        closeButton.draw(batch, parentAlpha);
    }

}
