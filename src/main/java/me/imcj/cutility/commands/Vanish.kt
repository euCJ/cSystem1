package me.imcj.cutility.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class VanishCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            // Verifica se o jogador tem permissão para usar o comando
            if (sender.hasPermission("c.utils.vanish")) {
                if (args.isNotEmpty() && args[0].equals("ver", ignoreCase = true)) {
                    // Se o primeiro argumento for "ver", exibe a lista de jogadores invisíveis para o jogador
                    val vanishedPlayers = getVanishedPlayers(sender)
                    if (vanishedPlayers.isNotEmpty()) {
                        val message = "${ChatColor.YELLOW}${ChatColor.BOLD} VANISH ${ChatColor.YELLOW}➜ Jogadores invisíveis:${ChatColor.GRAY} ${vanishedPlayers.joinToString(", ")}"
                        sender.sendMessage(message)
                    } else {
                        sender.sendMessage("${ChatColor.RED}${ChatColor.BOLD} VANISH ${ChatColor.RED}➜ Não há jogadores invisíveis no momento.")
                    }
                } else {
                    // Define o estado de invisibilidade do jogador
                    val isVanished = !sender.isInvisible
                    sender.isInvisible = isVanished

                    // Envia uma mensagem para o jogador informando o seu estado de invisibilidade
                    val message = if (isVanished) {
                        "${ChatColor.YELLOW}${ChatColor.BOLD} VANISH${ChatColor.YELLOW} ➜ Você entrou no modo ${ChatColor.AQUA}Vanish${ChatColor.YELLOW}!"
                    } else {
                        "${ChatColor.YELLOW}${ChatColor.BOLD} VANISH${ChatColor.YELLOW} ➜ Você saiu do modo ${ChatColor.AQUA}Vanish${ChatColor.YELLOW}!"
                    }
                    sender.sendMessage(message)
                }
            } else {
                // Caso o jogador não tenha permissão, envia uma mensagem de erro
                sender.sendMessage("${ChatColor.RED}Você não tem permissão para usar esse comando!")
            }
        } else {
            // Caso o comando seja executado pelo console, envia uma mensagem de erro
            sender.sendMessage("${ChatColor.RED}Esse comando só pode ser executado por um jogador!")
        }
        return true
    }

    private fun getVanishedPlayers(player: Player): List<String> {
        val vanishedPlayers = mutableListOf<String>()
        for (onlinePlayer in player.server.onlinePlayers) {
            if (onlinePlayer.isInvisible) {
                vanishedPlayers.add(onlinePlayer.name)
            }
        }
        return vanishedPlayers
    }

}

