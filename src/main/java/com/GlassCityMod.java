package com.glasscity;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class GlassCityMod implements ModInitializer {

    public static final String MOD_ID = "glasscity";

    public static final Logger LOGGER =
            LoggerFactory.getLogger(MOD_ID);
    
    private static SelectionManager selectionManager;
    
    private static GlassCityMod INSTANCE;

    public GlassCityMod() {
        INSTANCE = this;
    }
    
    public static SelectionManager getSelectionManager() {
    return selectionManager;
}
    
    public static GlassCityMod getInstance() {
        return INSTANCE;
    }

    @Override
    public void onInitialize() {

        LOGGER.info("==================================");
        LOGGER.info(" Glass City Generator");
        LOGGER.info(" Version : 0.1.0");
        LOGGER.info(" Minecraft : 1.20.4");
        LOGGER.info("==================================");

        selectionManager = new SelectionManager();

        registerManagers();

        registerEvents();

        LOGGER.info("Glass City Generator Loaded.");
    }

    /**
     * マネージャの生成
     */
    private void registerManagers() {

        LOGGER.info("Loading managers...");

        // v0.2.0
        // SelectionManager

        // v0.3.0
        // ConfigManager

        // v0.4.0
        // CityGenerator

    }

    /**
     * Event登録
     */
    private void registerEvents() {

        LOGGER.info("Registering events...");

        // v0.2.0
        // SelectionEvents.register();

    }

}
