package game.player;

import base.Attribute;
import base.FrameCounter;
import base.GameObjectManager;
import input.KeyboardEvent;

public class PlayerShoot implements Attribute<Player> {
    private FrameCounter frameCounter = new FrameCounter(10);
    private int enegy = 0;

    @Override
    public void run(Player gameObject) {
        if (KeyboardEvent.instance.isSpace && this.frameCounter.checkCounter() && this.enegy < 100) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(gameObject.position.x - 3, gameObject.position.y - 19);
            bulletPlayer.velocity.set(0, -4.5f);
            GameObjectManager.instance.add(bulletPlayer);
            this.enegy++;
            this.frameCounter.resetCount();
        }
        if (!KeyboardEvent.instance.isSpace && enegy > 0) {
            enegy --;
        }
    }
}
