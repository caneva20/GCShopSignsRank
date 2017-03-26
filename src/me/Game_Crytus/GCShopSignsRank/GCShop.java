package me.Game_Crytus.GCShopSignsRank;

import org.bukkit.plugin.java.JavaPlugin;

public class GCShop extends JavaPlugin {
    @Override
    public void onEnable() {
        GCLogger.initialize(this, "GCShopSignsRank");
        initializeListeners();
        saveDefaultConfig();
        PermissionHandler.Initialize(this);
        RanksManager.initialize(this);

        GCLogger.infoConsole("GCShopSignsRank Enabled!");
    }

    @Override
    public void onDisable() {
        GCLogger.infoConsole("GCShopSignsRank Disabled!");
    }

    private void initializeListeners() {
        getServer().getPluginManager().registerEvents(new OnInteract(this), this);
        getServer().getPluginManager().registerEvents(new OnBreak(), this);
        getServer().getPluginManager().registerEvents(new OnPlace(), this);
        GCLogger.infoConsole("Listeners initialized!");
    }
}
