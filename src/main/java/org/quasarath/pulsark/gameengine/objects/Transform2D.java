package org.quasarath.pulsark.gameengine.objects;

public class Transform2D {
    
    private Vector2 position;
    private double rotation;
    private Vector2 scale;

    public Transform2D(Vector2 position, double rotation, Vector2 scale) {
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
    }
    public Transform2D(Vector2 position, double rotation) {
        this(position, rotation, new Vector2(1, 1));
    }
    public Transform2D(Vector2 position) {
        this(position, 0, new Vector2(1, 1));
    }


    public Vector2 getPosition() {
        return this.position;
    }
    public double getRotation() {
        return this.rotation;
    }
    public Vector2 getScale() {
        return this.scale;
    }


    public void setPosition(Vector2 position) {
        this.position = position;
    }
    public void setPosition(double x, double y) {
        this.position.setValues(x, y);
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public void setScale(Vector2 scale) {
        this.scale = scale;
    }
    public void setScale(double sx, double sy, double sz) {
        this.scale.setValues(sx, sy);
    }
}
