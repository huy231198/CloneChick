package game.star;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class Star extends GameObject implements PhysicBody {
    public Vector2D velocity;
    private BoxCollider boxCollider;
    private RunHitObject runHitObject;

    public Star() {
        this.renderer = new ImageRenderer("image/explosion.png", 10, 10);
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20, 20);
        this.runHitObject = new RunHitObject(Player.class);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        this.runHitObject.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }

    @Override
    public void getHit(GameObject gameObject) {
        ExplosionStar explosionStar = GameObjectManager.instance.recycle(ExplosionStar.class);
        explosionStar.create(this.position);
        this.isAlive = false;


    }
}
