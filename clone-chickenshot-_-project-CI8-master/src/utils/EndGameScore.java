package utils;

import base.GameObject;
import base.GameObjectManager;
import renderer.TextRenderer;

import java.awt.*;

public class EndGameScore extends GameObject {

    public String score;

    public EndGameScore() {
        this.score = String.valueOf(GameObjectManager.instance.score);

        this.position.set(80, 350);
        this.renderer = new TextRenderer(
                "Your final score is: " + this.score,
                Color.WHITE,
                "Agency FB",
                80
        );
    }
}
