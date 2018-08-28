package utils;

import base.GameObject;
import renderer.TextRenderer;

import java.awt.*;

public class GameOverText extends GameObject {

    public GameOverText() {
        this.position.set(60, 250);
        this.renderer = new TextRenderer(
                "GAME OVER",
                Color.WHITE,
                "Agency FB",
                150
        );
    }
}
