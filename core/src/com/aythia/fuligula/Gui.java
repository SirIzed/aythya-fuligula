package com.aythia.fuligula;

import com.aythia.fuligula.libgdx.ui.TextField;
import com.aythia.fuligula.libgdx.ui.Window;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Created on 25/05/2014.
 */
public class Gui {
    static Stage stage;
    Skin skin;
    int uiSize = 12;

    Gui(Stage stage) {
        this.stage = stage;
        initSkin();
        stage.addActor(aWindow());
        stage.addActor(anotherWindow());
        stage.addActor(aScrollPane());
    }

    private void initSkin() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("courier.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = uiSize;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        skin = new Skin();
        skin.add("default-font", font, BitmapFont.class);
        skin.addRegions(new TextureAtlas(Gdx.files.internal("ui_parts/ui_parts.atlas")));
        skin.load(Gdx.files.internal("ui_parts/ui_parts.json"));

        ScrollPane.ScrollPaneStyle scrollPaneStyle = skin.get(ScrollPane.ScrollPaneStyle.class);
        scrollPaneStyle.vScroll.setMinHeight(uiSize);
        scrollPaneStyle.vScroll.setMinWidth(uiSize);
        scrollPaneStyle.vScrollKnob.setMinHeight(uiSize);
        scrollPaneStyle.vScrollKnob.setMinWidth(uiSize);
        scrollPaneStyle.hScroll.setMinHeight(uiSize);
        scrollPaneStyle.hScroll.setMinWidth(uiSize);
        scrollPaneStyle.hScrollKnob.setMinHeight(uiSize);
        scrollPaneStyle.hScrollKnob.setMinWidth(uiSize);

    }

    private Window aWindow() {
        Window window = new Window("A wéndow", skin);
        addContentToWindow(window);
        window.setResizable(true);
        window.pack();
        window.setPosition(100, 100);
        return window;
    }

    private void addContentToWindow(Window window) {
        window.add("a line");
        window.row();
        window.add("éèà€");
        window.row();
        window.add(new TextField("test", skin, stage));
        window.row();
        window.add(new TextField("test", skin, stage));

    }

    private Window anotherWindow() {
        Window.WindowStyle windowStyle = new com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle(skin.get(Window.WindowStyle.class));
        Window window = new Window("Another wéndow", skin);
        windowStyle.background = skin.newDrawable(("white-border-background"), new Color(1, 0, 1, 1));
        window.setStyle(windowStyle);
        addContentToWindow(window);
        window.setResizable(true);
        window.pack();
        window.setPosition(200, 0);
        return window;

    }

    private Window aScrollPane() {
        Window window = new Window("ScrollPane", skin);

        Table content = new Table(skin);
        ScrollPane scrollPane = new ScrollPane(content, skin);
        window.add(scrollPane).fill().expand();
        scrollPane.setFadeScrollBars(false);
        content.add("one truc one truc one truc");
        for (int i=0; i < 10; i += 1) {
            content.row();
            content.add("one truc");

        }
        content.row();
        content.add("dernier truc");
        content.pack();

        window.getCell(scrollPane).minWidth(content.getWidth() + uiSize);
        window.setResizable(true);
        window.pack();

        return window;
    }
}
