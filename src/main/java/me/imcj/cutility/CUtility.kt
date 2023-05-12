package me.imcj.cutility

import me.imcj.cutility.commands.*
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin

class CUtility : JavaPlugin() {

    private lateinit var configManager: ConfigManager
    lateinit var examples: List<Map<String, Any>>

    override fun onEnable() {
        // Plugin startup logic
        getLogger().info("O plugin foi incializado!")

        configManager = ConfigManager(this)
        val config = configManager.getConfig()

        // Faz a leitura do config.yml
        if (!config.getBoolean("Helloworldcmd.habilitado", true)) {
            getCommand("helloworld")?.setExecutor(null)
        } else {
            getCommand("helloword")?.setExecutor(HelloWordCmd)
        }
        //Habilita ou desabilita o comando: Hellowordcmd
        if (!config.getBoolean("Cores.habilitado", true)) {
            getCommand("cores")?.setExecutor(null)
        } else {
            getCommand("cores")?.setExecutor(ChatColors)
        }
        // Cores
        if (!config.getBoolean("Ping.habilitado", true)) {
            getCommand("ping")?.setExecutor(null)
        } else {
            getCommand("ping")?.setExecutor(PingCommand())
        }
        // Ping
        if (!config.getBoolean("Bigorna.habilitado", true)) {
            getCommand("bigorna")?.setExecutor(null)
        } else {
            getCommand("bigorna")?.setExecutor(AnvilCommand())
        }
        // Bigorna
        if (!config.getBoolean("EChest.habilitado", true)) {
            getCommand("echest")?.setExecutor(null)
        } else {
            getCommand("echest")?.setExecutor(EnderChestCommand())
        }
        // Ender Chest
        if (!config.getBoolean("Chapeu.habilitado", true)) {
            getCommand("chapeu")?.setExecutor(null)
        } else {
            getCommand("chapeu")?.setExecutor(HatCommand())
        }
        // Chapeu
        if (!config.getBoolean("Sudo.habilitado", true)) {
            getCommand("sudo")?.setExecutor(null)
        } else {
            getCommand("sudo")?.setExecutor(SudoCommand())
        }
        // Sudo
        if (!config.getBoolean("Craft.habilitado", true)) {
            getCommand("craft")?.setExecutor(null)
        } else {
            getCommand("craft")?.setExecutor(CraftCommand())
        }
        // Crafting Table
        if (!config.getBoolean("Vanish.habilitado", true)) {
            getCommand("vanish")?.setExecutor(null)
        } else {
            getCommand("vanish")?.setExecutor(VanishCommand())
        }
        // Vanish

        val ajudaComando = AjudaComando(this)
        getCommand("cUtils")?.setExecutor(ajudaComando)
        getCommand("cUtils")?.aliases = listOf("ajuda", "help")

        // Comandos com Alias
        if (!config.getBoolean("InvSee.habilitado", true)) {
            // Desabilita o comando
            getCommand("invsee")?.setExecutor(null)
        } else {
            val executor = getCommand("invsee")?.setExecutor(InvseeCommand())
        }
        // InvSee
        if (!config.getBoolean("Luz.habilitado", true)) {
            // Desabilita o comando
            getCommand("light")?.setExecutor(null)
            getCommand("luz")?.setExecutor(null)
        } else {
            val lightCommand = getCommand("light")
            lightCommand?.setExecutor(LightCommand())
            val luzCommand = getCommand("luz")
            luzCommand?.setExecutor(LightCommand())
        }
        // Luz
        if (!config.getBoolean("Luz.habilitado", true)) {
            // Desabilita o comando
            getCommand("voar")?.setExecutor(null)
            getCommand("fly")?.setExecutor(null)
        } else {
            val flyCommand = getCommand("voar")
            val flyExecutor = FlyCommand()
            flyCommand?.setExecutor(flyExecutor)
            val flyAliasCommand = getCommand("fly")
            flyAliasCommand?.setExecutor(flyExecutor)
        }
        getCommand("cutils")?.setExecutor(this)

        val reloadCommand = ReloadCommand(this)
        getCommand("cutils reload")?.setExecutor(reloadCommand)
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (command.name == "cutils" && args.isNotEmpty() && args[0] == "reload") {
            reloadConfig() // ou qualquer outra ação de reload necessária
            sender.sendMessage("Plugin recarregado.")
            return true
        }
        return false
    }

    override fun onDisable() {
        // Plugin shutdown logic
        configManager.save()
        getLogger().info("O Plugin foi finalizado!")

    }
}