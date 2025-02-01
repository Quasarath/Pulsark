package org.quasarath.pulsark.gameengine;

import org.joml.Vector3f;

import org.quasarath.pulsark.gameengine.objects.Position3D;
import org.quasarath.pulsark.gameengine.objects.Vector3;

public class Math {
    
    public static double cap(double val, double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("Bottom limit must be lower that upper limit");
        }

        if (val <= max && val >= min) {
            return val;
        }

        if (val > max) {
            return min + (val - max) % (max - min);
        }
        
        return max - (min - val) % (max - min);
    }

    public static Vector3f toVector3f(Vector3 v3) {
        float vx = (float) v3.getX();
        float vy = (float) v3.getY();
        float vz = (float) v3.getY();
        return new Vector3f(vx, vy, vz);
    }

    public static Vector3f toVector3f(Position3D p3d) {
        float vx = (float) p3d.getX();
        float vy = (float) p3d.getY();
        float vz = (float) p3d.getY();
        return new Vector3f(vx, vy, vz);
    }
}
