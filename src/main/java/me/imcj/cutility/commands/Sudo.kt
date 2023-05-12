package me.imcj.cutility.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SudoCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.size < 2) {
            sender.sendMessage("${ChatColor.RED}Use: /sudo (jogador) (comando)")
            return true
        }

        val player: Player? = Bukkit.getPlayer(args[0])
        if (player == null) {
            sender.sendMessage("${ChatColor.RED}Jogador não encontrado.")
            return true
        }

        // Verificar se o jogador tem a permissão 'c.utils.luz'
        if (!player.hasPermission("c.utils.luz")) {
            sender.sendMessage("${ChatColor.RED}O jogador não tem permissão para executar este comando.")
            return true
        }

        val cmd: String = args.slice(1 until args.size).joinToString(" ")

        Bukkit.getServer().dispatchCommand(player, cmd)

        sender.sendMessage("${ChatColor.GREEN}Comando executado '${cmd}' como ${ChatColor.YELLOW} ${player.name}${ChatColor.GREEN}.")
        return true
    }
}