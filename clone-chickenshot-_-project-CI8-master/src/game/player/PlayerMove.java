package game.player;

import base.Attribute;
import input.KeyboardEvent;

public class PlayerMove implements Attribute<Player> {
    @Override
    public void run(Player gameObject) {
        if (KeyboardEvent.instance.isA && gameObject.position.x > 8) {
            gameObject.position.x -= 3;
        }
        if (KeyboardEvent.instance.isD && gameObject.position.x < 1010) {
            gameObject.position.x += 3;
        }
        if (KeyboardEvent.instance.isW && gameObject.position.y > 10) {
            gameObject.position.y -= 3;
        }
        if (KeyboardEvent.instance.isS && gameObject.position.y < 590) {
            gameObject.position.y += 3;
        }
    }
}
