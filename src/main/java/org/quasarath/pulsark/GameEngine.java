package org.quasarath.pulsark;

import org.quasarath.pulsark.gameengine.IGameLogic;
import org.quasarath.pulsark.gameengine.objects.SemanticVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL33.*;

import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;


public class GameEngine {
    
    public static final SemanticVersion VERSION;

    private IGameLogic gameLogic;
    private String appTitle;
    private SemanticVersion appVersion;
    private boolean vSync;
    private short screenWidth;
    private short screenHeight;
    private byte screen;

    private Logger logger;
    private long mainWindow;
    private double lastFrameTime;

    static {
        SemanticVersion engineVersion = SemanticVersion.newRelease(0,0,0);
        try (InputStream manifestStream = GameEngine.class.getResourceAsStream("/META-INF/MANIFEST.MF")) {
            if (manifestStream != null) {
                Manifest manifest = new Manifest(manifestStream);
                Attributes attributes = manifest.getMainAttributes();
                String versionString = attributes.getValue("Implementation-Version");
                if (versionString != null) {
                    engineVersion = SemanticVersion.fromString(versionString);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        VERSION = engineVersion;
    }

    GameEngine(
        IGameLogic gameLogic,
        String appTitle,
        SemanticVersion appVersion,
        boolean vSync,
        short screenWidth,
        short screenHeight,
        byte screen
        ) {
        
        this.gameLogic = gameLogic;
        this.appTitle = appTitle;
        this.appVersion = appVersion;
        this.vSync = vSync;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.screen = screen;

        this.lastFrameTime = glfwGetTime();
        this.logger = LoggerFactory.getLogger("Pulsark/GameEngine");

        init();
        loop();
        cleanup();
    }

    private void init() {
        boolean init = glfwInit();
        if (!init) {
            this.logger.error("Could not initialize GLFW!");
            System.exit(10001);
        }

        String title = this.appTitle + " " + this.appVersion.toString();
        this.mainWindow = glfwCreateWindow(this.screenWidth, screenHeight, title, this.screen, 1);
        this.gameLogic.init(this.mainWindow);
        glfwShowWindow(this.mainWindow);
    }

    private void loop() {
        while (!glfwWindowShouldClose(this.mainWindow)) {
            double deltaT = glfwGetTime() - this.lastFrameTime;
            this.gameLogic.tick(deltaT);
        }
    }

    private void cleanup() {
        glfwDestroyWindow(GLFW_NO_WINDOW_CONTEXT);
        this.gameLogic.cleanup();
    }
}
