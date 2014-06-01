package com.aythia.fuligula.libgdx.listener;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

/**
 * Created on 01/06/2014.
 */
public class EnterListener implements TextField.TextFieldListener {
    Stage stage;
    public EnterListener(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void keyTyped(TextField textField, char c) {
        if ('\r' == c) {
            System.out.println("enter");
            stage.setKeyboardFocus(null);
        }
    }
}
