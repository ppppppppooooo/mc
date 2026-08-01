package com.glasscity;

import com.glasscity.selection.SelectionEvents;
import com.glasscity.selection.SelectionManager;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Glass City Generator
 *
 * Fabric 1.20.4
 */
public class GlassCityMod implements ModInitializer {

    public static final String MOD_ID = "glasscity";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static GlassCityMod instance;

    private SelectionManager selectionManager;

    public GlassCityMod() {
        instance = this;
    }

    @Override
    public void onInitialize() {

        LOGGER.info("======================================");
        LOGGER.info(" Glass City Generator Initializing...");
        LOGGER.info(" Minecraft : 1.20.4");
        LOGGER.info(" Fabric    : Loaded");
        LOGGER.info("======================================");

        /*
         * Managers
         */
        selectionManager = new SelectionManager();

        /*
         * Register Events
         */
        SelectionEvents.register(selectionManager);

        LOGGER.info("Selection system loaded.");

        LOGGER.info("Glass City Generator initialized successfully.");
    }

    /**
     * Singleton instance
     */
    public static GlassCityMod getInstance() {
        return instance;
    }

    /**
     * Global SelectionManager
     */
    public SelectionManager getSelectionManager() {
        return selectionManager;
    }

}
