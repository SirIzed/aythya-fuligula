package com.aythia.fuligula.libgdx.listener;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created on 01/06/2014.
 */
public class StageListener extends InputAdapter {
    private final Stage stage;

    public StageListener(Stage stage) {
        this.stage = stage;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        keyboard_focus(screenX, screenY);
        return false;
    }

    private void keyboard_focus(float x, float y) {
        Actor has_focus = stage.getKeyboardFocus();
        if ((has_focus != null) && (has_focus.hit(x, y, false) != has_focus)) {
            stage.setKeyboardFocus(null);
        }
        has_focus = stage.getScrollFocus();
        if ((has_focus != null) && (has_focus.hit(x, y, false) != has_focus)) {
            stage.setScrollFocus(null);
        }

    }
}
