package utils;

import base.GameObject;
import renderer.TextRenderer;

import java.awt.*;

public class StartGameText extends GameObject {

    public StartGameText() {
        this.position.set(160, 200);
        this.renderer = new TextRenderer(
                "CHICKEN INVADER",
                Color.WHITE,
                "Agency FB",
                130
        );
    }
}
