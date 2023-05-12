package me.imcj.cutility.commands

import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class PingCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("${ChatColor.RED}Este comando só pode ser executado por jogadores.")
            return true
        }

        val target: Player = if (args.isEmpty()) {
            sender // sem argumentos, usa o jogador que executou o comando como alvo
        } else {
            sender.server.getPlayer(args[0]) // usa o jogador especificado como alvo
        } ?: run {
            sender.sendMessage("${ChatColor.RED}${ChatColor.BOLD}PING ${ChatColor.RED}➜ Jogador não encontrado.")
            return true
        }

        if (sender == target) {
            val ping = target.spigot().ping // obtém o ping do jogador que executou o comando

            // envia uma mensagem personalizada com o ping do jogador que executou o comando
            sender.sendMessage("${ChatColor.GREEN}${ChatColor.BOLD}PING ➜ ${ChatColor.GRAY}Seu ping: ${ChatColor.GREEN}${ping}ms")

            // reproduz o som BLOCK_NOTE_BLOCK_PLING para o jogador que executou o comando
            sender.playSound(sender.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 1f)
        } else {
            val ping = target.spigot().ping // obtém o ping do jogador especificado

            // envia uma mensagem personalizada com o ping do jogador especificado
            sender.sendMessage("${ChatColor.GREEN}PING ${ChatColor.RESET}${ChatColor.GRAY}➜ O ping de ${target.displayName} é: ${ChatColor.GREEN}${ping}ms")

            // reproduz o som BLOCK_NOTE_BLOCK_PLING para o jogador que executou o comando
            sender.playSound(sender.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 1f)

            if (sender.hasPermission("minecraft.command.playSound")) {
                // faça alguma coisa que requer a permissão
            } else {
                sender.sendMessage("${ChatColor.RED}${ChatColor.BOLD}PING ${ChatColor.RESET}${ChatColor.RED}➜ Você não tem permissão para executar este comando.")
            }
        }

        return true
    }
}