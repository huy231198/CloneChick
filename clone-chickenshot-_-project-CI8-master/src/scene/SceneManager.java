package scene;

public class SceneManager {

    public static SceneManager instance = new SceneManager();

    private Scene currentScene;
    private Scene nextScene;

    // set to 1 at boss scene
    public int isBossScene = 0;

    private SceneManager() {}

    public void changeScene(Scene scene) {
        this.nextScene = scene;
    }

    public void performChangeSceneIfNeeded() {
        if (this.nextScene == null) return;
        if (this.currentScene != null) this.currentScene.deinit();
        this.nextScene.init();
        this.currentScene = this.nextScene;
        this.nextScene = null;
    }
}
