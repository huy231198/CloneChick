package utils;

import base.GameObject;
import renderer.TextRenderer;

import java.awt.*;

public class StartGameText extends GameObject {

    public StartGameText() {
        this.position.set(10, 300);
        this.renderer = new TextRenderer(
                "CHICKEN INVANDER",
                Color.WHITE,
                "Agency FB",
                100
        );
    }
}
