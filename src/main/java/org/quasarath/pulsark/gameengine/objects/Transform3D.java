package org.quasarath.pulsark.gameengine.objects;

import org.quasarath.pulsark.gameengine.Math;

public class Transform3D {
    
    private Vector3 pos;
    private Vector3 rot;
    private Vector3 scale;

    public static final Transform3D ZERO;

    static {
        ZERO = new Transform3D();
    }

    public Transform3D() {
        this(Vector3.ZERO, Vector3.ZERO, Vector3.ZERO);
    }
    public Transform3D(Vector3 pos) {
        this(pos, Vector3.ZERO, Vector3.ZERO);
    }
    public Transform3D(Vector3 pos, Vector3 rot) {
        this(pos, rot, Vector3.ZERO);
    }
    public Transform3D(Transform3D t) {
        this(t.getPos(), t.getRot(), t.getScale());
    }
    public Transform3D(Vector3 pos, Vector3 rot, Vector3 scale) {
        this.pos = pos;
        this.rot = rot;
        this.scale = scale;
    }

    public void set(Transform3D t) {
        this.pos = t.getPos();
        this.rot = t.getRot();
        this.scale = t.getScale();
    }

    public void setPos(Vector3 v) {
        this.pos = v;
    }

    public void setRot(Vector3 v) {
        double nx = v.getX();
        double ny = v.getY();
        double nz = v.getZ();
        nx = Math.cap(nx, -180, 180);
        nx = Math.cap(ny, -180, 180);
        nz = Math.cap(nz, -180, 180);
        this.rot.set(new Vector3(nx, ny ,nz));
    }

    public void setScale(Vector3 v) {
        if (v.getX() <= 0 | v.getY() <= 0 | v.getZ() <= 0) {
            throw new IllegalArgumentException("Scale vector must be higher than 0");
        }
        this.scale = v;
    }

    
    public Vector3 getPos() {
        return this.pos;
    }

    public Vector3 getRot() {
        return this.rot;
    }

    public Vector3 getScale() {
        return this.scale;
    }

    public void move(Vector3 v) {
        this.pos.chg(v);
    }

    public void rotate(Vector3 v) {
        double nx = this.rot.getX() + v.getX();
        double ny = this.rot.getY() + v.getY();
        double nz = this.rot.getZ() + v.getZ();
        nx = Math.cap(nx, -180, 180);
        nx = Math.cap(ny, -180, 180);
        nz = Math.cap(nz, -180, 180);
        this.rot.set(new Vector3(nx, ny ,nz));
    }
}
