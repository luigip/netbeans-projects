
package myanim;

import java.awt.Color;

public abstract class Shape {
    protected double weight;
    protected double sizeX;
    protected double sizeY;
    protected double posX;
    protected double posY;
    protected double bounce;
    protected double velX;
    protected double velY;
    protected boolean atRest;
    protected Color color;

    public Shape(){
        this(1, 1, 1);
    }
    public Shape(double weight, double sizeX, double sizeY){
        this.weight = weight;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public double getSizeX() {
        return sizeX;
    }
    public void setSizeX(double sizeX) {
        this.sizeX = sizeX;
    }
    public double getSizeY() {
        return sizeY;
    }
    public void setSizeY(double sizeY) {
        this.sizeY = sizeY;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBounce() {
        return bounce;
    }

    public void setBounce(double bounce) {
        this.bounce = bounce;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public boolean isAtRest() {
        return atRest;
    }

    public void setAtRest(boolean atRest) {
        this.atRest = atRest;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}

class ShapeFactory {
    public static Shape getShape(Shapes type){
        Shape shape = null;
        shape = getShape(type, 1, 1, 1);
        return shape;
    }
    public static Shape getShape(Shapes type, double weight, double sizeX, double sizeY){
        Shape shape = null;
        switch (type){
            case CIRCLE: shape = new Circle(weight, sizeX, sizeY); break;
            case SQUARE: shape = new Square(weight, sizeX, sizeY);
        }
        return shape;
    }
}

enum Shapes{
    CIRCLE,
    SQUARE;
}

class Circle extends Shape {

    public Circle(double weight, double sizeX, double sizeY) {
        super(weight, sizeX, sizeY);
    }

}

class Square extends Shape {
    public Square(double weight, double sizeX, double sizeY) {
        super(weight, sizeX, sizeY);
    }
}