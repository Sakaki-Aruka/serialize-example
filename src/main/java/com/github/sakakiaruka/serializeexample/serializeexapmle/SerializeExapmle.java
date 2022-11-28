package com.github.sakakiaruka.serializeexample.serializeexapmle;

import org.bukkit.plugin.java.JavaPlugin;

public final class SerializeExapmle extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("serialize").setExecutor(new SerializeMain());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
