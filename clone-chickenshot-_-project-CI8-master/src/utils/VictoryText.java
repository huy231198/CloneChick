package utils;

import base.GameObject;
import renderer.TextRenderer;

import java.awt.*;

public class VictoryText extends GameObject {

    public VictoryText() {
        this.position.set(90, 250);
        this.renderer = new TextRenderer(
                "WINNER WINNER CHICKEN DINNER!",
                Color.WHITE,
                "Agency FB",
                80
        );
    }
}
