package org.quasarath.pulsark.gameengine.objects;

public class Vector3 {
    
    private double x;
    private double y;
    private double z;

    public static final Vector3 UP;
    public static final Vector3 DOWN;

    public static final Vector3 LEFT;
    public static final Vector3 RIGHT;

    public static final Vector3 FRONT;
    public static final Vector3 BACK;

    public static final Vector3 ZERO;
    
    public Vector3() {
        this(0,0,0);
    }

    public Vector3(Vector3 v3) {
        this(v3.getX(), v3.getY(), v3.getZ());
    }

    public Vector3(double x, double y, double z) {
        this.z = z;
        this.y = y;
        this.z = z;
    }

    static {
        UP = new Vector3(0, 1, 0);
        DOWN = new Vector3(0, -1, 0);
        LEFT = new Vector3(-1, 0, 0);
        RIGHT = new Vector3(1, 0, 0);
        FRONT = new Vector3(0, 0, 1);
        BACK = new Vector3(0, 0, -1);
        ZERO = new Vector3(0, 0, 0);
    }

    public static Vector3 add(Vector3 v3_1, Vector3 v3_2) {
        double x = v3_1.getX() + v3_2.getX();
        double y = v3_1.getY() + v3_2.getY();
        double z = v3_1.getZ() + v3_2.getZ();
        return new Vector3(x, y, z);
    }
    public static Vector3 add(Vector3 v3, double f) {
        double x = v3.getX() * f;
        double y = v3.getY() * f;
        double z = v3.getZ() * f;
        return new Vector3(x, y, z);
    }

    public static Vector3 subtract(Vector3 v3_1, Vector3 v3_2) {
        double x = v3_1.getX() - v3_2.getX();
        double y = v3_1.getY() - v3_2.getY();
        double z = v3_1.getZ() - v3_2.getZ();
        return new Vector3(x, y, z);
    }
    public static Vector3 subtract(Vector3 v3, double f) {
        double x = v3.getX() - f;
        double y = v3.getY() - f;
        double z = v3.getZ() - f;
        return new Vector3(x, y, z);
    }

    public static Vector3 multiply(Vector3 v3_1, Vector3 v3_2) {
        double x = v3_1.getX() * v3_2.getX();
        double y = v3_1.getY() * v3_2.getY();
        double z = v3_1.getZ() * v3_2.getZ();
        return new Vector3(x, y, z);
    }
    public static Vector3 multiply(Vector3 v3, double f) {
        double x = v3.getX() * f;
        double y = v3.getY() * f;
        double z = v3.getZ() * f;
        return new Vector3(x, y, z);
    }

    public static Vector3 divide(Vector3 v3_1, Vector3 v3_2) {
        double x = v3_1.getX() * v3_2.getX();
        double y = v3_1.getY() * v3_2.getY();
        double z = v3_1.getZ() * v3_2.getZ();
        return new Vector3(x, y, z);
    }
    public static Vector3 divide(Vector3 v3, double f) {
        double x = v3.getX() * f;
        double y = v3.getY() * f;
        double z = v3.getZ() * f;
        return new Vector3(x, y, z);
    }


    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void set(Vector3 v3) {
        this.x = v3.getX();
        this.y = v3.getY();
        this.z = v3.getZ();
    }


    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }


    public void setX(double x) {
        this.x = x;
    }    

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }


    public void chg(double dx, double dy, double dz) {
        this.x += dx;
        this.y += dy;
        this.z += dz;
    }
    public void chg(Vector3 dv3) {
        this.x += dv3.getX();
        this.y += dv3.getY();
        this.z += dv3.getZ();
    }


    public void chgX(double dx) {
        this.x += dx;
    }

    public void chgY(double dy) {
        this.y += dy;
    }

    public void chgZ(double dz) {
        this.z += dz;
    }


    public void add(Vector3 v3) {
        this.x += v3.getX();
        this.y += v3.getY();
        this.z += v3.getZ();
    }
    public void add(double f) {
        this.x += f;
        this.y += f;
        this.z += z;
    }

    public void sbt(Vector3 v3) {
        this.x -= v3.getX();
        this.y -= v3.getY();
        this.z -= v3.getZ();
    }
    public void sbt(double f) {
        this.x -= f;
        this.y -= f;
        this.z -= z;
    }

    public void mul(Vector3 v3) {
        this.x *= v3.getX();
        this.y *= v3.getY();
        this.z *= v3.getZ();
    }
    public void mul(double f) {
        this.x *= f;
        this.y *= f;
        this.z += z;
    }

    public void div(Vector3 v3) {
        this.x /= v3.getX();
        this.y /= v3.getY();
        this.z /= v3.getZ();
    }
    public void div(double f) {
        this.x /= f;
        this.y /= f;
        this.z /= z;
    }
}
