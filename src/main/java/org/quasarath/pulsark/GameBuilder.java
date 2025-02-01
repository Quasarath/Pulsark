package org.quasarath.pulsark;

import org.quasarath.pulsark.gameengine.IGameLogic;
import org.quasarath.pulsark.gameengine.objects.SemanticVersion;

public class GameBuilder {
    
    private String appTitle;
    private SemanticVersion appVersion;
    private IGameLogic gameLogic;
    private boolean vSync;
    private short screenWidth;
    private short screenHeight;
    private byte screenId;

    public GameBuilder() {
        this.appTitle = "Pulsark " + GameEngine.VERSION.toString();
        this.appVersion = GameEngine.VERSION;
        this.vSync = false;
        this.screenWidth = 800;
        this.screenHeight = 600;
        this.screenId = 0;
    }

    public GameBuilder setTitle(String title) {
        this.appTitle = title;
        return this;
    }

    public GameBuilder setVersion(SemanticVersion version) {
        this.appVersion = version;
        return this;
    }

    public GameBuilder setGameLogic(IGameLogic gameLogic) {
        this.gameLogic = gameLogic;
        return this;
    }

    public GameBuilder setScreenWidth(short screenWidth) {
        this.screenWidth = screenWidth;
        return this;
    }

    public GameBuilder setScreenHeight(short screenHeight) {
        this.screenHeight = screenHeight;
        return this;
    }

    public GameBuilder setVSync (boolean vSync) {
        this.vSync = vSync;
        return this;
    }

    public GameBuilder setScreen(byte screenId) {
        this.screenId = screenId;
        return this;
    }

    public GameEngine build() {
        if (this.gameLogic == null) {
            throw new IllegalStateException("GameLogic is null");
        }
        return new GameEngine(
            this.gameLogic,
            this.appTitle, 
            this.appVersion, 
            this.vSync, 
            this.screenWidth,
            this.screenHeight,
            this.screenId
        );
    }
}
