package game.enemy.enemybehind;

import base.Attribute;
import base.FrameCounter;

public class EnemyBehindMove implements Attribute<EnemyBehind> {

    private FrameCounter frameCounter1 = new FrameCounter(5);
    private FrameCounter frameCounter2 = new FrameCounter(5);

    @Override
    public void run(EnemyBehind gameObject) {
        if (gameObject.leftRight == 1) {
            if (gameObject.position.y < 400 && gameObject.angle < 10 && gameObject.upDown == 1) gameObject.angle += 0.3;
            if (gameObject.position.y < 400 && gameObject.angle < 10 && gameObject.upDown == 0) gameObject.angle += 0.4;

            if (this.frameCounter1.checkCounter()) {
                if (gameObject.velocity.x >= 0 && gameObject.velocity.y < 0) {
                    gameObject.velocity.set(gameObject.velocity.rotate(gameObject.angle));
                } else if (gameObject.angle > 10) {
                    gameObject.velocity.set(5, 0);
                }
                this.frameCounter1.resetCount();
            }
        } else {
            if (gameObject.position.y < 400 && gameObject.angle > -10 && gameObject.upDown == 1)
                gameObject.angle -= 0.3;
            if (gameObject.position.y < 400 && gameObject.angle > -10 && gameObject.upDown == 0)
                gameObject.angle -= 0.4;

            if (this.frameCounter2.checkCounter()) {
                if (gameObject.velocity.x <= 0 && gameObject.velocity.y < 0) {
                    gameObject.velocity.set(gameObject.velocity.rotate(gameObject.angle));
                } else if (gameObject.angle < -10) {
                    gameObject.velocity.set(-5, 0);
                }
                this.frameCounter2.resetCount();
            }
        }
    }
}
