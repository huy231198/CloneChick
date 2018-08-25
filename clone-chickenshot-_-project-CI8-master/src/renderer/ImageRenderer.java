package renderer;

import base.Vector2D;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import utils.Utils;

public class ImageRenderer implements Renderer {
    private BufferedImage image;
    private int width;
    private int height;

    public ImageRenderer(String path,int width,int height){
        this.image = Utils.loadImage(path);
        this.width = width;
        this.height = height;
    }
//    private BufferedImage loadImage(String path) {
//        try {
//            return ImageIO.read(new File(path));
//        } catch (IOException e) {
//            return null;
//        }
//    }
    @Override
    public void render(Graphics graphics, Vector2D position) {
        if (this.image != null) {
            graphics.drawImage(this.image, (int)position.x - this.image.getWidth() / 2, (int)position.y - this.image.getHeight() / 2, null);
        }
    }
}