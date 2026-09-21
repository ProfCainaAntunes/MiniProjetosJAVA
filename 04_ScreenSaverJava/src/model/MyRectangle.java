package model;

import java.awt.Graphics2D;

public class MyRectangle extends Shape {
  

    public MyRectangle(int width, int height, int screenWidth, int screenHeight){
        super(width,height,screenWidth,screenHeight);
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    
}
