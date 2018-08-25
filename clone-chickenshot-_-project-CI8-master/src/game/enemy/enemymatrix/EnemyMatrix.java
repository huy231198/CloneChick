package game.enemy.enemymatrix;

import base.GameObject;
import base.Vector2D;
import game.player.BulletPlayer;
import game.player.Player;
import physic.BoxCollider;
import physic.HitPoints;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.OvalRenderer;

import java.awt.*;

public class EnemyMatrix extends GameObject implements PhysicBody, HitPoints {
    public Vector2D velocity;
    public Vector2D temp;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private int hitPoints;

    public EnemyMatrix() {
        this.hitPoints = 1;
        this.velocity = new Vector2D(2.5f, 0);
        this.boxCollider = new BoxCollider(16, 16);
        this.renderer = new OvalRenderer(Color.WHITE, 16, 16);
        this.temp = new Vector2D(this.position.x, this.position.y);
        this.attributes.add(new EnemyMatrixShoot());
        this.attributes.add(new EnemyMatrixMove());
        this.runHitObject = new RunHitObject(Player.class);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position.x - 8, this.position.y - 8);
        this.attributes.add(new EnemyMatrixMove());
        this.runHitObject.run(this);

        if (this.position.y > 600) this.isAlive = false;
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        getHitPoint(gameObject);
        if(this.hitPoints==0)
            this.isAlive = false;
    }

    @Override
    public void getHitPoint(GameObject gameObject) {
        if(gameObject instanceof Player)
            this.hitPoints=0;
        if(gameObject instanceof BulletPlayer) {
            this.hitPoints=0;
//            this.hitPoints-=((BulletPlayer) gameObject).force;
        }


    }
}

