package me.imcj.cutility

import org.bukkit.ChatColor
import org.bukkit.command.CommandExecutor
import org.bukkit.plugin.Plugin
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class ReloadCommand(private val plugin: Plugin) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (label.equals("cutils", ignoreCase = true) && args.isNotEmpty() && args[0].equals("reload", ignoreCase = true)) {
            plugin.reloadConfig()
            sender.sendMessage(ChatColor.GREEN.toString() + "Configuração recarregada com sucesso!")
            return true
        }
        return false
    }
}
