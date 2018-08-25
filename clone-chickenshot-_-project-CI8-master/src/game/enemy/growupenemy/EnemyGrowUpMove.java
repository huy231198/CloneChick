package game.enemy.growupenemy;

import base.Attribute;

public class EnemyGrowUpMove implements Attribute<EnemyGrowUp> {

    @Override
    public void run(EnemyGrowUp gameObject) {
        if(gameObject.position.y<0||gameObject.position.y>600-gameObject.height){
            gameObject.velocity.y=-gameObject.velocity.y;
        }
        if(gameObject.position.x<0||gameObject.position.x>1024-gameObject.width){
            gameObject.velocity.x=-gameObject.velocity.x;
        }
    }
}
