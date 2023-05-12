package me.imcj.cutility.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object ChatColors : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false
        val name = sender.displayName
        sender.sendMessage("")
        sender.sendMessage("§aOi, §e$name§a as §bC§ao§9r§ce§es §ado §l§7Minecraft §r§asão:")
        sender.sendMessage("")
        sender.sendMessage("§a&a §b&b §c&c §d&d")
        sender.sendMessage("§e&e §f&f §1&1 §2&2")
        sender.sendMessage("§3&3 §4&4 §5&5 §6&6")
        sender.sendMessage("§7&7 §8&8 §9&9 §0&0")
        sender.sendMessage("")
        sender.sendMessage("&k §kMinecraft")
        sender.sendMessage("&l §lMinecraft")
        sender.sendMessage("&m §mMinecraft")
        sender.sendMessage("&n §nMinecraft")
        sender.sendMessage("&o §oMinecraft")
        sender.sendMessage("&r §rMinecraft")
        sender.sendMessage("")
        return true
    }
}