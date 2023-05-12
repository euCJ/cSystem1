package me.imcj.cutility

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import java.io.File

class ConfigManager(private val plugin: Plugin) {
    private val configFile = File(plugin.dataFolder, "config.yml")
    private var config: YamlConfiguration? = null

    init {
        if (!configFile.exists()) {
            plugin.saveResource("config.yml", false)
        }

        config = YamlConfiguration.loadConfiguration(configFile)
    }

    fun save() {
        config?.save(configFile)
    }

    fun getConfig(): YamlConfiguration {
        return config!!
    }
}