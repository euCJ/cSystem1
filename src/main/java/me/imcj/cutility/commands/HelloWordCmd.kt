package me.imcj.cutility.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import kotlin.random.Random

object HelloWordCmd : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false
        val name = sender.displayName
        val number = Random.nextInt(0,100)
        sender.sendMessage("§aOi, §e$name§a! Seu número é §e$number §a;)")
        return true
    }
}