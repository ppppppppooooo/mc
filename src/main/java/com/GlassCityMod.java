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

    private SelectionManager selectionManager;
private SelectionEvents selectionEvents;

    @Override
    public void onInitialize() {
        selectionManager = new SelectionManager();

selectionEvents = new SelectionEvents(selectionManager);

selectionEvents.register();
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
