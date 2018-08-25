package game.enemy.meteor;

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

public class Meteor extends GameObject implements PhysicBody, HitPoints {
    public Vector2D velocity;

    public BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private int hitPoints;

    public Meteor() {
        this.hitPoints = 10;
        this.velocity = new Vector2D();
        this.renderer = new OvalRenderer(Color.RED, 25, 25);
        this.boxCollider = new BoxCollider(25, 25);
        this.runHitObject = new RunHitObject(Player.class);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set((float)(this.position.x - 12.5), (float)(this.position.y - 12.5));
        this.runHitObject.run(this);

        if (this.position.y > 600) this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.getHitPoint(gameObject);
        if(this.hitPoints == 0){
            GameObjectManager.instance.score += 100;
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
