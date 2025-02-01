package org.quasarath.pulsark.gameengine.objects;
public class Vector2 {
    
    private double x;
    private double y;


    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Vector2() {
        this(0, 0);
    }


    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    public void setValues(double x, double y) {
        this.x = x;
        this.y = y;
    }   


    public void add(Vector2 other) {
        this.x += other.getX();
        this.y += other.getY();
    }
    public void subtract(Vector2 other) {
        this.x -= other.getX();
        this.y -= other.getY();
    }

    public void multiply(double value) {
        this.x *= value;
        this.y *= value;
    }
    public void divide(double value) {
        this.x /= value;
        this.y /= value;
    }

    public Vector2 copy() {
        return new Vector2(this.x, this.y);
    }
}
