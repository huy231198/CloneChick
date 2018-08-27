package utils;

import base.GameObject;
import input.KeyboardEvent;
import renderer.TextRenderer;
import scene.SceneManager;
import scene.StartScene;

import java.awt.*;

public class EndGamePressSpaceText extends GameObject {

    public EndGamePressSpaceText() {
        this.position.set(180, 480);
        this.renderer = new TextRenderer(
                "Press space to return to the start menu",
                Color.WHITE,
                "Agency FB",
                50
        );
    }

    @Override
    public void run() {
        if (KeyboardEvent.instance.isSpace) SceneManager.instance.changeScene(new StartScene());
    }
}
