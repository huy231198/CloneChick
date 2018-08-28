package game.background;

import base.GameObject;
import renderer.BackgroundRenderer;
import renderer.ImageRenderer;
import renderer.RectRenderer;

import java.awt.*;

public class Background extends GameObject {
    public Background() {
        this.position.set(0, 0);
        this.renderer = new BackgroundRenderer("clone-chickenshot-_-project-CI8-master/image/8320.jpg", 1024, 600);
        // this.renderer = new RectRenderer(Color.BLACK,1024,600);
    }
}
