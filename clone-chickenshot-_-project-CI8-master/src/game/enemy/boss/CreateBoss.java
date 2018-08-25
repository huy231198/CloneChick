package game.enemy.boss;

import base.GameObject;
import base.GameObjectManager;

public class CreateBoss extends GameObject {

    @Override
    public void run() {
        super.run();
        Boss boss = GameObjectManager.instance.recycle(Boss.class);
        boss.position.set(400 ,50);
        boss.velocity.set(10, 0);
    }

}
