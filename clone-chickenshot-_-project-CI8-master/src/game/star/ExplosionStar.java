package game.star;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExplosionStar extends GameObject {
    private Random random;
    private List<ParticleStar> particleStars;

    public ExplosionStar(){
        this.random = new Random();
        this.particleStars = new ArrayList<>();
    } public void create(Vector2D position) {
        for (double angle = 0.0; angle <= 360.0; angle += 360.0 / 37) {
            ParticleStar particleSquare = GameObjectManager.instance.recycle(ParticleStar.class);
            particleSquare.position.set(position);
            Vector2D vector2D = new Vector2D(0, 1);
            Vector2D rotate = vector2D.rotate(angle);
            particleSquare.velocity.set(rotate).multiply(this.random.nextFloat() * 3);
            particleSquare.frameCounter.setMax(this.random.nextInt(20) + 5);
            this.particleStars.add(particleSquare);
        }
    }

    @Override
    public void run() {
        super.run();
        //chay qua tat ca phan tu, neu phan tu nao thoa man dk truyen vao thi xoa
        this.particleStars.removeIf(particleSquare -> !particleSquare.isAlive);
        if (this.particleStars.isEmpty()) {
            this.isAlive = false;
        }
    }

}
