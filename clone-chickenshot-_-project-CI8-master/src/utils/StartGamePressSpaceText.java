package utils;

import base.GameObject;
import input.KeyboardEvent;
import renderer.TextRenderer;
import scene.EnemyScene;
import scene.SceneManager;

import java.awt.*;

public class StartGamePressSpaceText extends GameObject {

    public StartGamePressSpaceText() {
        this.position.set(100, 350);
        this.renderer = new TextRenderer(
                "Press space to start the game!",
                Color.WHITE,
                "Agency FB",
                60
        );
    }

    @Override
    public void run() {
        if (KeyboardEvent.instance.isSpace) SceneManager.instance.changeScene(new EnemyScene());
    }
}
