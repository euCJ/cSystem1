package me.imcj.cutility.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class EnderChestCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Este comando só pode ser executado por jogadores.")
            return true
        }

        if (!sender.hasPermission("c.utils.workbench")) {
            sender.sendMessage("Você não tem permissão para executar este comando.")
            return true
        }

        sender.openInventory(sender.enderChest)
        return true
    }

}