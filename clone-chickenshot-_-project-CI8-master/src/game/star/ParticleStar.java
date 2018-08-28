package game.star;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

import java.util.Random;

public class ParticleStar extends GameObject {
    private String[] urls;
    private Random random;
    public Vector2D velocity;
    public FrameCounter frameCounter;

    public ParticleStar(){
        this.random = new Random();
        this.urls = new String[]{
                "image/explosion.png",
                "image/explosion (1).png"
        };

        this.renderer = new ImageRenderer(this.urls[this.random.nextInt(this.urls.length)], 10, 10);
        this.velocity = new Vector2D();
        this.frameCounter = new FrameCounter(this.random.nextInt(40) + 30);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        if (this.frameCounter.checkCounter()) {
            this.isAlive = false;
            this.frameCounter.resetCount();
        }
    }
}
