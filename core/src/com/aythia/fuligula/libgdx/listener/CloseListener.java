package com.aythia.fuligula.libgdx.listener;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created on 30/05/2014.
 */
public class CloseListener extends ClickListener {

    private Actor actor;

    public CloseListener(Actor actor) {
        this.actor = actor;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        actor.setVisible(false);
    }
    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        event.stop();
        return super.touchDown(event, x, y, pointer, button);
    }

}
