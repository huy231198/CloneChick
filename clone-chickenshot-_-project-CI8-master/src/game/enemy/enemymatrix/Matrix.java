package game.enemy.enemymatrix;

import base.GameObject;
import base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;

public class Matrix extends GameObject {

    int i;

    public List<EnemyMatrix> enemyMatrices = new ArrayList<>();

    public Matrix() {
        this.createEnemies();
    }

    @Override
    public void run() {
        super.run();
        this.checkAlive();
    }

    public void createEnemies() {
        for(i=0;i<=15;i++) {
            EnemyMatrix enemyMatrix = GameObjectManager.instance.recycle(EnemyMatrix.class);
            enemyMatrix.position.set((i%4)*25,(i/4)*25);
            enemyMatrix.velocity.set(2.5f, 0);
            enemyMatrix.temp.set(enemyMatrix.position);
            this.enemyMatrices.add(enemyMatrix);
        }
    }

    public void checkAlive() {
        enemyMatrices.removeIf(enemy -> !enemy.isAlive);
        if (this.enemyMatrices.isEmpty()) {
            this.isAlive = false;
            this.createEnemies();
        }
    }
}
