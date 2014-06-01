package com.aythia.fuligula.libgdx.ui;

import com.aythia.fuligula.libgdx.listener.EnterListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created on 01/06/2014.
 */
public class TextField extends com.badlogic.gdx.scenes.scene2d.ui.TextField {

    public TextField(String text, Skin skin, Stage stage) {
        super(text, skin);
        setTextFieldListener(new EnterListener(stage));
        setFocusTraversal(false);
    }
}
