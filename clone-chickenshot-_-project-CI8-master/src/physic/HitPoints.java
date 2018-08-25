package physic;

import base.GameObject;

public interface HitPoints<T extends GameObject & PhysicBody> {
    void getHitPoint(T gameObject);
}
