package game.enemy.boss;

import base.Attribute;
import base.FrameCounter;
import base.GameObjectManager;
import game.enemy.MissileEnemy;

public class BossMissileShoot implements Attribute<Boss> {

    private FrameCounter frameCounter = new FrameCounter(300);

    @Override
    public void run(Boss gameObject) {
        if (this.frameCounter.checkCounter()) {
            MissileEnemy missileEnemy = GameObjectManager.instance.recycle(MissileEnemy.class);
            missileEnemy.position.set(gameObject.position);

            this.frameCounter.resetCount();
        }
    }
}
