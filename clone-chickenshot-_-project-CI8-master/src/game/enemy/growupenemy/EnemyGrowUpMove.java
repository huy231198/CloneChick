package game.enemy.growupenemy;

import base.Attribute;

public class EnemyGrowUpMove implements Attribute<EnemyGrowUp> {

    @Override
    public void run(EnemyGrowUp gameObject) {
        if (gameObject.position.y < 50 || gameObject.position.y > 500) {
            gameObject.velocity.y = -gameObject.velocity.y;
        }
        if (gameObject.position.x < 0 || gameObject.position.x > 924) {
            gameObject.velocity.x = -gameObject.velocity.x;
        }
    }
}
