package me.imcj.cutility.commands

import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class HatCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("${ChatColor.RED}Este comando só pode ser executado por jogadores.")
            return true
        }

        if (!sender.hasPermission("c.utils.chapeu")) {
            sender.sendMessage("${ChatColor.GRAY}CHAPEU ➜ ${ChatColor.RED}}Você não tem permissão para executar este comando.")
            return true
        }

        val hand = sender.inventory.itemInMainHand

        if (hand.type.isAir) {
            sender.sendMessage("${ChatColor.GRAY}CHAPEU ➜ ${ChatColor.RED}Você não está segurando nenhum ${ChatColor.GRAY}item/block ${ChatColor.RED}na mão.")
            return true
        }

        val helmet = sender.inventory.helmet

        if (helmet != null) {
            sender.inventory.helmet = hand
            sender.inventory.setItemInMainHand(helmet)
        } else {
            sender.inventory.helmet = hand
            sender.inventory.setItemInMainHand(null)
        }

        sender.sendMessage("${ChatColor.GRAY}CHAPEU ➜ ${ChatColor.GREEN}O bloco que você estava segurando na mão agora está no topo da sua cabeça.")
        sender.playSound(sender.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 1f)
        return true
    }

}