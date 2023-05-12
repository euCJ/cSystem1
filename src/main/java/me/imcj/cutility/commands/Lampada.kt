package me.imcj.cutility.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class LightCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            if (sender.hasPermission("c.utils.luz")) { // Verifica se o jogador tem a permissão "c.utils.luz"
                val hasNightVision = sender.hasPotionEffect(PotionEffectType.NIGHT_VISION)
                if (!hasNightVision) {
                    val effect = PotionEffect(PotionEffectType.NIGHT_VISION, Int.MAX_VALUE, 0, false, false)
                    sender.addPotionEffect(effect)
                    sender.sendMessage(ChatColor.GREEN.toString() + "Visão noturna ativada!")
                } else {
                    sender.removePotionEffect(PotionEffectType.NIGHT_VISION)
                    sender.sendMessage(ChatColor.RED.toString() + "Visão noturna desativada!")
                }
            } else {
                sender.sendMessage(ChatColor.RED.toString() + "Você não tem permissão para usar este comando!")
            }
        } else {
            sender.sendMessage("Este comando só pode ser executado por jogadores!")
        }
        return true
    }
}