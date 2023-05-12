package me.imcj.cutility.commands

import org.bukkit.ChatColor
import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class FlyCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("${ChatColor.RED}Esse comando pode ser usado apenas por jogadores.")
            return true
        }

        val player = sender as Player

        if (!player.hasPermission("c.utils.voar")) {
            player.sendMessage("${ChatColor.RED}Você não tem permissão para usar esse comando.")
            return true
        }

        if (player.gameMode == GameMode.SPECTATOR) {
            player.sendMessage("${ChatColor.RED}Você não pode usar esse comando no modo \"${ChatColor.YELLOW}espectador${ChatColor.RED}.")
            return true
        }

        val isFlying = player.allowFlight

        player.allowFlight = !isFlying
        player.isFlying = false

        if (!isFlying) {
            player.sendMessage("${ChatColor.YELLOW}Voar foi habilitado.")
        } else {
            player.sendMessage("${ChatColor.YELLOW}Voar foi desabilitado.")
        }

        return true
    }
}