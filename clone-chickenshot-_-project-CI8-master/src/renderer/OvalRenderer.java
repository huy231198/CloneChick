package renderer;

import base.Vector2D;

import java.awt.*;

public class OvalRenderer implements Renderer {
    public int width;
    public int height;
    private Color color;

    public OvalRenderer(Color color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.setColor(this.color);
        graphics.fillOval((int) position.x, (int) position.y, this.width, this.height);
    }
}