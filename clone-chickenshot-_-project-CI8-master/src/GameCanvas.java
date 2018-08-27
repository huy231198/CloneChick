import base.GameObject;
import base.GameObjectManager;
import game.background.Background;
import game.enemy.boss.Boss;
import game.enemy.enemybehind.CreateEnemyBehind;
import game.enemy.enemymatrix.CreateMatrix;
import game.enemy.enemytravel.CreateEnemyTravel;
import game.enemy.growupenemy.CreateEnemyGrowUp;
import game.enemy.roundshootenemy.CreateRoundShootEnemy;
import game.enemy.meteor.CreateMeteor;
import game.gift.CreateBulletGift;
import game.player.BagEnegyBullet;
import game.player.EnegyBullet;
import game.player.HitPointPlayer;
import game.player.Player;
import game.score.Score;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    public Player player;
    private BufferedImage backBuffered;
    private Graphics graphics;

    public Boss boss;

    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(200, 300);
        GameObjectManager.instance.add(player);
    }
    private void setupBoss() {
        this.boss = new Boss();
        this.boss.position.set(400, 50);
        GameObjectManager.instance.add(boss);
    }

    public void runAll() {
        GameObjectManager.instance.runAll();
    }

    public GameCanvas() {
        this.setSize(1024, 600);
        setupBackBuffered();
        setupCharacter();
//        setupBoss();
        this.setVisible(true);
    }

    private void setupCharacter() {
        GameObjectManager.instance.add(new Background());
        setupPlayer();
//        GameObjectManager.instance.add(new CreateMatrix());
//        GameObjectManager.instance.add(new CreateEnemyTravel());
 //       GameObjectManager.instance.add(new CreateEnemyGrowUp());
        GameObjectManager.instance.add(new CreateRoundShootEnemy());
//       GameObjectManager.instance.add(new CreateMeteor());
//        GameObjectManager.instance.add(new CreateEnemyBehind());
        GameObjectManager.instance.add(new BagEnegyBullet());
        GameObjectManager.instance.add(new EnegyBullet());
        GameObjectManager.instance.add(new Score());
        GameObjectManager.instance.add(new HitPointPlayer());
        GameObjectManager.instance.add(new CreateBulletGift());
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(graphics);
        this.repaint();
    }
}
