package org.quasarath.pulsark.gameengine.objects;

public class Position3D {

    private long x;
    private long y;
    private long z;

    public static final Position3D UP;
    public static final Position3D DOWN;

    public static final Position3D LEFT;
    public static final Position3D RIGHT;

    public static final Position3D FRONT;
    public static final Position3D BACK;

    public static final Position3D ZERO;
    
    public Position3D() {
        this(0,0,0);
    }

    public Position3D(Position3D v3) {
        this(v3.getX(), v3.getY(), v3.getZ());
    }

    public Position3D(long x, long y, long z) {
        this.z = z;
        this.y = y;
        this.z = z;
    }

    static {
        UP = new Position3D(0, 1, 0);
        DOWN = new Position3D(0, -1, 0);
        LEFT = new Position3D(-1, 0, 0);
        RIGHT = new Position3D(1, 0, 0);
        FRONT = new Position3D(0, 0, 1);
        BACK = new Position3D(0, 0, -1);
        ZERO = new Position3D(0, 0, 0);
    }

    public static Position3D add(Position3D v3_1, Position3D v3_2) {
        long x = v3_1.getX() + v3_2.getX();
        long y = v3_1.getY() + v3_2.getY();
        long z = v3_1.getZ() + v3_2.getZ();
        return new Position3D(x, y, z);
    }
    public static Position3D add(Position3D v3, long f) {
        long x = v3.getX() * f;
        long y = v3.getY() * f;
        long z = v3.getZ() * f;
        return new Position3D(x, y, z);
    }

    public static Position3D subtract(Position3D v3_1, Position3D v3_2) {
        long x = v3_1.getX() - v3_2.getX();
        long y = v3_1.getY() - v3_2.getY();
        long z = v3_1.getZ() - v3_2.getZ();
        return new Position3D(x, y, z);
    }
    public static Position3D subtract(Position3D v3, long f) {
        long x = v3.getX() - f;
        long y = v3.getY() - f;
        long z = v3.getZ() - f;
        return new Position3D(x, y, z);
    }

    public static Position3D multiply(Position3D v3_1, Position3D v3_2) {
        long x = v3_1.getX() * v3_2.getX();
        long y = v3_1.getY() * v3_2.getY();
        long z = v3_1.getZ() * v3_2.getZ();
        return new Position3D(x, y, z);
    }
    public static Position3D multiply(Position3D v3, long f) {
        long x = v3.getX() * f;
        long y = v3.getY() * f;
        long z = v3.getZ() * f;
        return new Position3D(x, y, z);
    }

    public static Position3D divide(Position3D v3_1, Position3D v3_2) {
        long x = v3_1.getX() * v3_2.getX();
        long y = v3_1.getY() * v3_2.getY();
        long z = v3_1.getZ() * v3_2.getZ();
        return new Position3D(x, y, z);
    }
    public static Position3D divide(Position3D v3, long f) {
        long x = v3.getX() * f;
        long y = v3.getY() * f;
        long z = v3.getZ() * f;
        return new Position3D(x, y, z);
    }


    public void set(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void set(Position3D v3) {
        this.x = v3.getX();
        this.y = v3.getY();
        this.z = v3.getZ();
    }


    public long getX() {
        return this.x;
    }

    public long getY() {
        return this.y;
    }

    public long getZ() {
        return this.z;
    }


    public void setX(long x) {
        this.x = x;
    }    

    public void setY(long y) {
        this.y = y;
    }

    public void setZ(long z) {
        this.z = z;
    }


    public void chg(long dx, long dy, long dz) {
        this.x += dx;
        this.y += dy;
        this.z += dz;
    }
    public void chg(Position3D dv3) {
        this.x += dv3.getX();
        this.y += dv3.getY();
        this.z += dv3.getZ();
    }


    public void chgX(long dx) {
        this.x += dx;
    }

    public void chgY(long dy) {
        this.y += dy;
    }

    public void chgZ(long dz) {
        this.z += dz;
    }


    public void add(Position3D v3) {
        this.x += v3.getX();
        this.y += v3.getY();
        this.z += v3.getZ();
    }
    public void add(long f) {
        this.x += f;
        this.y += f;
        this.z += z;
    }

    public void sbt(Position3D v3) {
        this.x -= v3.getX();
        this.y -= v3.getY();
        this.z -= v3.getZ();
    }
    public void sbt(long f) {
        this.x -= f;
        this.y -= f;
        this.z -= z;
    }

    public void mul(Position3D v3) {
        this.x *= v3.getX();
        this.y *= v3.getY();
        this.z *= v3.getZ();
    }
    public void mul(long f) {
        this.x *= f;
        this.y *= f;
        this.z += z;
    }

    public void div(Position3D v3) {
        this.x /= v3.getX();
        this.y /= v3.getY();
        this.z /= v3.getZ();
    }
    public void div(long f) {
        this.x /= f;
        this.y /= f;
        this.z /= z;
    }
}
