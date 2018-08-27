package scene;

import base.GameObjectManager;
import game.background.Background;
import utils.EndGamePressSpaceText;
import utils.EndGameScore;
import utils.VictoryText;

public class VictoryScene implements Scene {

    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        GameObjectManager.instance.recycle(VictoryText.class);
        GameObjectManager.instance.recycle(EndGameScore.class);
        GameObjectManager.instance.recycle(EndGamePressSpaceText.class);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
