package game.enemy.growupenemy;

import action.*;
import base.GameObject;
import base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateEnemyGrowUp extends GameObject {

    private Random random = new Random();

    public List<EnemyGrowUp> enemyGrowUps = new ArrayList<>();

    public CreateEnemyGrowUp() {
        this.configAction();
    }

    public void configAction() {
        Action createAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                EnemyGrowUp enemyGrowUp = GameObjectManager.instance.recycle(EnemyGrowUp.class);
                enemyGrowUp.position.set(random.nextInt(1024), 50);
                enemyGrowUp.velocity.set(random.nextInt(3) + 1, random.nextInt(3) + 1);
                enemyGrowUps.add(enemyGrowUp);
                return true;
            }
        };

        Action waitAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                enemyGrowUps.removeIf(enemy -> !enemy.isAlive);
                return enemyGrowUps.size()==1;
            }
        };

        this.addAction(
                new SequenceAction(
                        new WaitAction(2000),
                        createAction,
                        new RepeatActionForever(
                                new SequenceAction(
                                        waitAction,
                                        createAction
                                )
                        )
                )
        );
    }
}
