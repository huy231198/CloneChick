package game.player;

import base.GameObject;
import base.Vector2D;
import game.enemy.BulletEnemy;
import game.enemy.enemymatrix.EnemyMatrix;
import game.enemy.enemytravel.EnemyTravel;
import game.gift.BulletGift;
import physic.BoxCollider;
import physic.HitPoints;
import physic.PhysicBody;
import renderer.ImageRenderer;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject implements PhysicBody, HitPoints {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    public int angle;
    public int force;
    public int hitPoints;

    public Player() {
        this.hitPoints = 20;
        this.force=1;
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(60, 50);
//        this.renderer = new PolygonRenderer(Color.RED,
//                new Vector2D(8,0),
//                new Vector2D(0, 20),
//                new Vector2D(16, 20));
        this.renderer=new ImageRenderer("clone-chickenshot-_-project-CI8-master/image/spaceship.png",60,50);
        this.attributes.add(new PlayerShoot());
        this.attributes.add(new PlayerMove());
    }
    @Override
    public void run(){
        super.run();
     //   ((PolygonRenderer) this.renderer).angle = this.angle;
        this.boxCollider.position.set(this.position.x - 30, this.position.y -25);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        getHitPoint(gameObject);
        if(this.hitPoints <=0)
            this.isAlive = false;
    }

    @Override
    public void getHitPoint(GameObject gameObject) {
        if(gameObject instanceof EnemyMatrix){
            this.hitPoints-=3;
            this.force--;
        }
        if(gameObject instanceof EnemyTravel){
            this.hitPoints-=3;
            this.force--;
        }

        if(gameObject instanceof BulletEnemy){
            this.hitPoints--;
            this.force--;
        }


    }
}
