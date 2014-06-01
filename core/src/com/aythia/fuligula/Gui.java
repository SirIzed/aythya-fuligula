package com.aythia.fuligula;

import com.aythia.fuligula.libgdx.listener.EnterListener;
import com.aythia.fuligula.libgdx.ui.TextField;
import com.aythia.fuligula.libgdx.ui.Window;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created on 25/05/2014.
 */
public class Gui {
    static Stage stage;
    Skin skin;

    Gui(Stage stage) {
        this.stage = stage;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("courier.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 22;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        skin = new Skin();
        skin.addRegions(new TextureAtlas(Gdx.files.internal("skin/window_background.atlas")));
        skin.add("default-font", font, BitmapFont.class);
        skin.load(Gdx.files.internal("skin/window_background.json"));

        Window test = new Window("A wéndow", skin);
        test.padTop(parameter.size);
        test.add("a line");
        test.row();
        test.add("éèà€");
        test.row();
        test.add(new TextField("test", skin, stage));
        test.row();
        test.add(new TextField("test", skin, stage));

        test.setResizable(true);
        stage.addActor(test);

        test.pack();

        Window.WindowStyle window = skin.get(Window.WindowStyle.class);
        window.background = skin.newDrawable(("border-background"), new Color(1, 0, 1, 1));

        test = new Window("Another", skin);
        test.setStyle(window);
        test.add("2nd window");
        test.row();
        TextField textField = new TextField("test", skin, stage);
        textField.setTextFieldListener(new EnterListener(stage));
        test.add(textField);


        test.setResizable(true);
        test.pack();

        stage.addActor(test);

    }
}
