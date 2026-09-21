package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public abstract class Shape {
    protected int x;
    protected int y;
    protected int speedX;
    protected int speedY;
    protected int width;
    protected int height;
    protected Color color;

    public Shape(int width, int height, int screenWidth, int screenHeight){
        
        if(width>screenWidth)
            throw new IllegalArgumentException("The width cannot be greater than the window.");
        if(height>screenHeight)
            throw new IllegalArgumentException("The height cannot be greater than the window.");

        Random r = new Random();
        this.width = width;
        this.height = height;
        x = r.nextInt(screenWidth-width);
        y = r.nextInt(screenHeight)-height;
        speedX = r.nextInt(6)+1;
        speedY = r.nextInt(6)+1;
        color = colorGenerate();
    }

    private Color colorGenerate(){
        Random r = new Random();
        return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    public abstract void draw(Graphics2D g);

    public void move(int screenWidth, int screenHeight){
        x+=speedX;
        y+=speedY;
        getCollision(screenWidth,screenHeight);
    }

    private void getCollision(int screenWidth, int screenHeight){
        if(x+width>=screenWidth||x<0){
            speedX*=-1;
            color = colorGenerate();
        }
        if(y+height>=screenHeight||y<0){
            speedY*=-1;
            color = colorGenerate();
        }
    }
}
