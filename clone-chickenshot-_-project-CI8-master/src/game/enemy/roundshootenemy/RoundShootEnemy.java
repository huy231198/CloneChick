package game.enemy.roundshootenemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.BulletPlayer;
import game.player.Player;
import game.score.Score;
import physic.BoxCollider;
import physic.HitPoints;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.OvalRenderer;

import java.awt.*;

public class RoundShootEnemy extends GameObject implements PhysicBody, HitPoints {
    public Vector2D velocity;

    public BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private int hitPoints;

    public RoundShootEnemy() {
        this.hitPoints = 5;
        this.velocity = new Vector2D();
        this.renderer = new OvalRenderer(Color.WHITE, 16, 16);
        this.attributes.add(new RoundShootEnemyShoot());
        this.boxCollider = new BoxCollider(16, 16);
        this.runHitObject = new RunHitObject(Player.class);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 8, this.position.y - 8);
        this.runHitObject.run(this);

        if (this.position.y > 600 || this.position.y < 0) this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.getHitPoint(gameObject);
        if(this.hitPoints == 0){
            GameObjectManager.instance.score+=50;
            this.isAlive = false;
        }
    }

    @Override
    public void getHitPoint(GameObject gameObject) {
        if(gameObject instanceof Player)
            this.hitPoints=0;
        if(gameObject instanceof BulletPlayer){
            Player player = GameObjectManager.instance.findPlayer();
            this.hitPoints-=player.force;
        }
    }
}
