package me.imcj.cutility.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class InvseeCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (!sender.hasPermission("c.utils.invsee")) {
            sender.sendMessage("${ChatColor.RED}Você não tem permissão para usar este comando.")
            return true
        }

        if (args.isEmpty()) {
            sender.sendMessage("${ChatColor.RED}Use: /invsee (jogador)")
            return true
        }

        val player: Player? = Bukkit.getPlayer(args[0])
        if (player == null) {
            sender.sendMessage("${ChatColor.RED}Jogador não encontrado.")
            return true
        }

        if (player == sender) {
            sender.sendMessage("${ChatColor.RED}Você não pode ver seu próprio inventário.")
            return true
        }

        (sender as? Player)?.openInventory(player.inventory)

        return true
    }
}
