package scene;

import base.GameObject;
import base.GameObjectManager;
import game.background.Background;
import game.enemy.enemybehind.CreateEnemyBehind;
import game.enemy.enemymatrix.CreateMatrix;
import game.enemy.enemytravel.CreateEnemyTravel;
import game.enemy.growupenemy.CreateEnemyGrowUp;
import game.enemy.meteor.CreateMeteor;
import game.enemy.roundshootenemy.CreateRoundShootEnemy;
import game.gift.CreateBulletGift;
import game.player.BagEnegyBullet;
import game.player.EnegyBullet;
import game.player.HitPointPlayer;
import game.player.Player;
import game.score.Score;

public class EnemyScene implements Scene {

    @Override
    public void init() {
        GameObjectManager.instance.add(new Background());

        setupPlayer();

        GameObjectManager.instance.add(new CreateMatrix());
        GameObjectManager.instance.add(new CreateEnemyTravel());
        GameObjectManager.instance.add(new CreateEnemyGrowUp());
        GameObjectManager.instance.add(new CreateRoundShootEnemy());
        GameObjectManager.instance.add(new CreateMeteor());
        GameObjectManager.instance.add(new CreateEnemyBehind());

        GameObjectManager.instance.add(new BagEnegyBullet());
        GameObjectManager.instance.add(new EnegyBullet());

        GameObjectManager.instance.add(new Score());

        GameObjectManager.instance.add(new HitPointPlayer());
        GameObjectManager.instance.add(new CreateBulletGift());
    }

    private void setupPlayer() {
        Player player = GameObjectManager.instance.recycle(Player.class);
        player.position.set(200, 300);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
