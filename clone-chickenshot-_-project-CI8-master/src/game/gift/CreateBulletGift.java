package game.gift;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import game.enemy.meteor.Meteor;

import java.util.Random;

public class CreateBulletGift extends GameObject {
    private Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter(1500);

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.checkCounter()) {
            BulletGift bulletGift = GameObjectManager.instance.recycle(BulletGift.class);
            bulletGift.position.set(random.nextInt(1024), 0);
            bulletGift.velocity.set(0,random.nextInt(2) + 2);
          //  System.out.println(meteor.velocity.x + " , " + meteor.velocity.y);
            this.frameCounter.resetCount();
        }
    }
}
