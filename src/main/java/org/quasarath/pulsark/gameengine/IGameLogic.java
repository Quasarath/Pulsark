package org.quasarath.pulsark.gameengine;

public interface IGameLogic {
    
    public void init(long windowId);

    public void tick(double deltaT);

    public void cleanup();
}
