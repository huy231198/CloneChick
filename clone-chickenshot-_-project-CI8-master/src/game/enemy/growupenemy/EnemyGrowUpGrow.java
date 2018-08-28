package game.enemy.growupenemy;

import base.Attribute;
import base.FrameCounter;
import renderer.ImageRenderer;

import java.util.Random;

public class EnemyGrowUpGrow implements Attribute<EnemyGrowUp> {
    private Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter(50 + random.nextInt(150));

    @Override
    public void run(EnemyGrowUp enemyGrowUp) {
        if (this.frameCounter.checkCounter()) {
            if (enemyGrowUp.width <= 100 && enemyGrowUp.height <= 100) {
                enemyGrowUp.width += 10;
                enemyGrowUp.height += 10;
                enemyGrowUp.boxCollider.set(enemyGrowUp.width, enemyGrowUp.height);
                this.frameCounter.resetCount();
            } else {
                if (enemyGrowUp.width == 110 && enemyGrowUp.height == 110) {
                    enemyGrowUp.renderer = new ImageRenderer("clone-chickenshot-_-project-CI8-master/image/chicken.png", enemyGrowUp.width, enemyGrowUp.height);
                    enemyGrowUp.boxCollider.set(enemyGrowUp.width, enemyGrowUp.height);
                    enemyGrowUp.width += 10;
                    enemyGrowUp.height += 10;
                }
            }

        }
    }
}
