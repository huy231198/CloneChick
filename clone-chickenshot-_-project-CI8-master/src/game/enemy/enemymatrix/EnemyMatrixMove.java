package game.enemy.enemymatrix;

import base.Attribute;
import base.Vector2D;

public class EnemyMatrixMove implements Attribute<EnemyMatrix> {
    private int count = 0;

    @Override
    public void run(EnemyMatrix gameObject) {
        if (count == 2) {
            if (Math.abs(gameObject.position.x - gameObject.temp.x) >= 1000){
                gameObject.velocity.set(0, -2.5f);
                gameObject.temp.set(gameObject.position);
            }
            if(Math.abs(gameObject.position.y - gameObject.temp.y) >= 300){
                gameObject.velocity.set(2.5f,0);
                gameObject.temp.set(gameObject.position);
                count = 0;
            }
        } else {
            if (Math.abs(gameObject.position.x - gameObject.temp.x) >= 650) {
                gameObject.velocity.set(0, 2.5f);
                gameObject.temp.set(gameObject.position);
                count++;
            }
            if (gameObject.position.y - gameObject.temp.y >= 100) {
                if (gameObject.position.x >= 625) {
                    gameObject.velocity.set(-2.5f, 0);
                    gameObject.temp.set(gameObject.position);
                    count++;
                } else {
                    gameObject.velocity.set(2.5f, 0);
                    gameObject.temp.set(gameObject.position);
                    count++;
                }
            }
        }
    }
}
