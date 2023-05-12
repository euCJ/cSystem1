package me.imcj.cutility.commands

import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CraftCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Este comando só pode ser executado por jogadores.")
            return true
        }

        if (!sender.hasPermission("c.utils.workbench")) {
            sender.sendMessage("${ChatColor.GRAY}CRAFT ➜ ${ChatColor.RED}Você não tem permissão para executar este comando.")
            sender.playSound(sender.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 1f)
            return true
        }

        sender.openWorkbench(null, true)
        return true
    }
}


