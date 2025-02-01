package org.quasarath.pulsark.gameengine.objects;

public abstract class GameObject {
    
    private Transform3D transform;

    public GameObject(Transform3D transform) {
        this.transform = transform;
    }

    public Transform3D getTransform() {
        return this.transform;
    }

    public void setTransform(Transform3D t3d) {
        this.transform = t3d;
    }
}
