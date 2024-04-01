package com.github.nindroida.nclash.utils;

import com.github.nindroida.nclash.NClash;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileManager {
    private final NClash plugin = NClash.getInstance();
    private String path = null;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    public FileManager(String path) {
        this.path = path;
        saveDefaultConfig(path);
    }

    /**
     * reloadConfig
     *
     * creates the config file, checks for errors, and saves it
     *
     * @param path name of file
     */
    public void reloadConfig(String path) {
        if (this.configFile == null) { this.configFile = new File(plugin.getDataFolder(), path); }
        this.dataConfig = YamlConfiguration.loadConfiguration(configFile);

        InputStream defaultStream = plugin.getResource(path);
        if (defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    /**
     * getConfig
     *
     * gets the config for read/write purposes
     *
     * @return the config file (duh)
     */
    public FileConfiguration getConfig() {
        if (this.dataConfig == null) { reloadConfig(path); }
        return this.dataConfig;
    }

    /**
     * saveDefaultConfig
     *
     * initializes the config file
     *
     * @param path name of file
     */
    public void saveDefaultConfig(String path) {
        if (this.configFile == null) { this.configFile = new File(plugin.getDataFolder(), path); }
        if (!this.configFile.exists()) { plugin.saveResource(path, false); }
    }


    // METHODS THAT IM PROLLY NOT GONNA USE AT LEAST FOR NOW

    /* saves the config AFTER we've added stuff to it */
    public void saveConfig() {
        if (this.dataConfig == null || this.configFile == null) { return; }
        try {
            this.getConfig().save(this.configFile);
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save config to " + this.configFile);
        }
    }

    public InputStream getFile(String file) {
        return plugin.getResource(file);
    }

}
