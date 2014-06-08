package com.aythia.fuligula.libgdx.ui;

import com.aythia.fuligula.libgdx.listener.CloseListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Created on 30/05/2014.
 */
public class Window extends com.badlogic.gdx.scenes.scene2d.ui.Window {
    protected Button closeButton;
    protected Drawable titleBackground;
    private Color titleColor = new Color();

    private float windowPadTop;
    private BitmapFontCache titleCache;
    private int titleAlignment = Align.center;

    public Window(String title, Skin skin) {
        super(title, skin);

        addMenuButton(skin);
        add("").height(0).width(getTitleWidth());
        row();
    }

    private void addMenuButton(Skin skin) {
        closeButton = new Button(skin, "close");
        titleBackground = skin.getDrawable("window-title-background");
        closeButton.addListener(new CloseListener(this));
        addActor(closeButton);
        setMenuButtonStyle(getStyle());
    }


    @Override
    protected void drawBackground(Batch batch, float parentAlpha, float x, float y) {
        float width = getWidth(), height = getHeight();
        float padTop = getPadTop();
        float padLeft = getPadLeft();
        float middleTitle = y + height - .5f * padTop;
        super.drawBackground(batch, parentAlpha, x, y);

        titleBackground.draw(batch, x + padLeft, y + height - padTop, width - padLeft - getPadRight(), padTop - windowPadTop);
        closeButton.setPosition(x + padLeft, middleTitle - 0.5f * closeButton.getHeight());
        closeButton.draw(batch, parentAlpha);

        // Draw the title without the batch transformed or clipping applied.
        y += height;
        BitmapFont.TextBounds bounds = titleCache.getBounds();
        if ((titleAlignment & Align.left) != 0)
            x += getPadLeft();
        else if ((titleAlignment & Align.right) != 0)
            x += width - bounds.width - getPadRight();
        else
            x += (width - bounds.width) / 2;
        if ((titleAlignment & Align.top) == 0) {
            if ((titleAlignment & Align.bottom) != 0)
                y -= padTop - bounds.height;
            else
                y -= (padTop - bounds.height) / 2;
        }
        titleCache.setColors(titleColor.set(getColor()).mul(getStyle().titleFontColor));
        titleCache.setPosition((int) x, (int) y);
        titleCache.draw(batch, parentAlpha);


    }

    @Override
    public void setStyle(WindowStyle style) {

        titleCache = new BitmapFontCache(style.titleFont);
        titleCache.setColor(style.titleFontColor);
        super.setStyle(style);
        windowPadTop = getPadTop();
        if (closeButton != null) {
            setMenuButtonStyle(style);
        }

    }

    private void setMenuButtonStyle(WindowStyle style) {
        float size = style.titleFont.getLineHeight();
        closeButton.setSize(0.8f * size, 0.8f * size);
        padTop(2 * windowPadTop + size);

    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
        titleCache.setMultiLineText(title, 0, 0);
    }

    @Override
    public void setTitleAlignment(int titleAlignment) {
        super.setTitleAlignment(titleAlignment);
        this.titleAlignment = titleAlignment;
    }

    @Override
    public float getTitleWidth() {

        return 1.2f * super.getTitleWidth() + 1.2f * closeButton.getWidth() + getPadLeft() + getPadRight();
    }
}
