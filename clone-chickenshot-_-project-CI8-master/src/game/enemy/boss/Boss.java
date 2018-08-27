package game.enemy.boss;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.BulletPlayer;
import game.player.Player;
import physic.BoxCollider;
import physic.HitPoints;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;
import renderer.OvalRenderer;

import java.awt.*;

public class Boss extends GameObject implements PhysicBody, HitPoints {

    public Vector2D velocity;

    public BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private int hitPoints;
    private static final int hp = 1000;

    public Boss() {
        this.hitPoints = hp;
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("clone-chickenshot-_-project-CI8-master/image/alien.png", 200, 200);
        this.boxCollider = new BoxCollider(200, 200);
        this.runHitObject = new RunHitObject(Player.class);

        this.attributes.add(new BossRoundShoot());
        this.attributes.add(new BossTripleShoot());
        this.attributes.add(new BossMissileShoot());
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 100, this.position.y - 100);
        this.runHitObject.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.getHitPoint(gameObject);
        if (this.hitPoints <= 0){
            this.hitPoints=hp;
            this.isAlive = false;
        }
 ;
    }

    @Override
    public void getHitPoint(GameObject gameObject) {
        if (gameObject instanceof Player)
            this.hitPoints = 0;
        if (gameObject instanceof BulletPlayer) {
            Player player = GameObjectManager.instance.findPlayer();
            this.hitPoints -= player.force;
        }
    }
}
