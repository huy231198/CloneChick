package game.enemy.roundshootenemy;

import action.*;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class CreateRoundShootEnemy extends GameObject {
    private Random random = new Random();

    public CreateRoundShootEnemy() {
        this.configAction();
    }

    public void configAction() {
        Action createAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                RoundShootEnemy roundShootEnemy = GameObjectManager.instance.recycle(RoundShootEnemy.class);
                roundShootEnemy.position.set(random.nextInt(1024), random.nextInt(300));
                roundShootEnemy.velocity.set(random.nextInt(2) + 1, 0);
                return true;
            }
        };

        this.addAction(
                new RepeatActionForever(
                        new SequenceAction(
                                new WaitAction(random.nextInt(1000) + 1000),
                                createAction
                        )
                )
        );
    }
}
