package game.enemy.growupenemy;

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
import java.util.Random;

public class EnemyGrowUp extends GameObject implements PhysicBody, HitPoints {
    public Vector2D velocity;

    public int width = 10;
    public int height = 10;

    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    private int hitPoints;

    public EnemyGrowUp() {
            Random random=new Random();
            this.hitPoints = 3;
            this.velocity = new Vector2D(random.nextInt(8),random.nextInt(8));
            this.boxCollider = new BoxCollider(10,10);
            this.renderer = new OvalRenderer(Color.WHITE, this.width, this.height);
            this.attributes.add(new EnemyGrowUpGrow());
            this.attributes.add(new EnemyGrowUpMove());
            this.runHitObject = new RunHitObject(Player.class);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        ((OvalRenderer)this.renderer).width = this.width;
        ((OvalRenderer)this.renderer).height = this.height;
        this.boxCollider.position.set(this.position.x - 8,this.position.y - 8);
        this.runHitObject.run(this);
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
        this.getHitPoint(gameObject);
        if(this.hitPoints == 0){
            this.width = 10;
            this.height = 10;
            GameObjectManager.instance.score+=30;
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
