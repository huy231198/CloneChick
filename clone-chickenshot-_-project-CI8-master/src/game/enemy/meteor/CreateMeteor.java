package game.enemy.meteor;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class CreateMeteor extends GameObject {

    private Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter(1500);

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.checkCounter()) {
            Meteor meteor = GameObjectManager.instance.recycle(Meteor.class);
            meteor.position.set(random.nextInt(1024), 0);
            meteor.velocity.set(0,random.nextInt(2) + 2);
            System.out.println(meteor.velocity.x + " , " + meteor.velocity.y);
            this.frameCounter.resetCount();
        }
    }
}
