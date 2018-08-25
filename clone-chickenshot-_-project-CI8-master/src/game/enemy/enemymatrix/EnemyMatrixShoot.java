package game.enemy.enemymatrix;

import base.Attribute;
import base.FrameCounter;
import base.GameObjectManager;
import game.enemy.BulletEnemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyMatrixShoot implements Attribute<EnemyMatrix> {
    private Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter(160 + random.nextInt(150));

    @Override
    public void run(EnemyMatrix enemyMatrix) {
        if (this.frameCounter.checkCounter()) {
            BulletEnemy bulletEnemy = GameObjectManager.instance.recycle(BulletEnemy.class);
            bulletEnemy.position.set(enemyMatrix.position);
            bulletEnemy.velocity.set(0, random.nextInt(2)+1);
            this.frameCounter.resetCount();
        }
    }
}

