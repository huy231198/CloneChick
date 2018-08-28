package game.enemy.enemybehind;

import action.*;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;

import java.util.Random;

public class CreateEnemyBehind extends GameObject {

    private Random random = new Random();

    private Vector2D positionLeft = new Vector2D(200, 600);
    private Vector2D positionRight = new Vector2D(800, 600);

    public CreateEnemyBehind() {
        this.configAction();
    }

    public void configAction() {
        Action createAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                for (int i = 0; i < 9; i++) {
                    EnemyBehind enemyBehindLeft1 = GameObjectManager.instance.recycle(EnemyBehind.class);
                    enemyBehindLeft1.position.set(positionLeft.x, positionLeft.y + i * 30);
                    enemyBehindLeft1.velocity.set(0, -5);

                    EnemyBehind enemyBehindLeft2 = GameObjectManager.instance.recycle(EnemyBehind.class);
                    enemyBehindLeft2.position.set(positionLeft.x + 40, positionLeft.y + i * 30);
                    enemyBehindLeft2.velocity.set(0, -5);
                    enemyBehindLeft2.upDown = 0;

                    EnemyBehind enemyBehindRight1 = GameObjectManager.instance.recycle(EnemyBehind.class);
                    enemyBehindRight1.position.set(positionRight.x - 40, positionRight.y + i * 30);
                    enemyBehindRight1.velocity.set(0, -5);
                    enemyBehindRight1.upDown = 0;
                    enemyBehindRight1.leftRight = 0;

                    EnemyBehind enemyBehindRight2 = GameObjectManager.instance.recycle(EnemyBehind.class);
                    enemyBehindRight2.position.set(positionRight.x, positionRight.y + i * 30);
                    enemyBehindRight2.velocity.set(0, -5);
                    enemyBehindRight2.leftRight = 0;
                }
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
