package game.enemy.enemymatrix;

import action.*;
import base.GameObject;
import base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;

public class CreateMatrix extends GameObject{

    public List<Matrix> matrices = new ArrayList<>();

    public CreateMatrix() { this.configAction(); }

    public void configAction() {
        Action createAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                Matrix matrix = GameObjectManager.instance.recycle(Matrix.class);
                matrices.add(matrix);
                return true;
            }
        };

        Action waitAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                matrices.removeIf(matrix -> !matrix.isAlive);
                return matrices.size()== 1;
            }
        };

        this.addAction(
                new SequenceAction(
                        new WaitAction(20),
                        createAction,
                        new RepeatActionForever(
                                new SequenceAction(
                                        new WaitAction(200),
                                        createAction,
                                        waitAction
                                )
                        )
                )
        );
    }
}
