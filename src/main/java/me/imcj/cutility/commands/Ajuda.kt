package me.imcj.cutility.commands

import org.bukkit.ChatColor
import net.md_5.bungee.api.chat.ClickEvent
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.CommandExecutor
import org.bukkit.plugin.Plugin

class AjudaComando(private val plugin: Plugin) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isNotEmpty() && args[0] == "ajuda") {
            sender.sendMessage("")
            sender.sendMessage("${ChatColor.YELLOW}${ChatColor.BOLD} cUtils${ChatColor.RESET}${ChatColor.YELLOW} v1.1 (build 0003a) ")
            sender.sendMessage("${ChatColor.GRAY} Powered by: ${ChatColor.RED}www.yt.com/ImCJey")
            sender.sendMessage("")
            sender.sendMessage("${ChatColor.GREEN} ■ ${ChatColor.GRAY}/ping (jogador) - Para descobrir a latência no servidor.")
            sender.sendMessage("${ChatColor.GREEN} ■ ${ChatColor.GRAY}/sudo (jogador) - Dar comandos por outros jogadores.")
            sender.sendMessage("${ChatColor.GREEN} ■ ${ChatColor.GRAY}/invsee (jogador) - Utilize para ver o inventario de um jogador.")
            sender.sendMessage("${ChatColor.GREEN} ■ ${ChatColor.GRAY}/cores - Utilize para ver as cores possivei no minecraft.")
            sender.sendMessage("${ChatColor.GREEN} ■ ${ChatColor.GRAY}/luz - Utilize para iluminar o servidor.")
            sender.sendMessage("${ChatColor.GREEN} ■ ${ChatColor.GRAY}/voar - Utilize para sobrevoar o lobby.")
            sender.sendMessage("${ChatColor.GREEN} ■ ${ChatColor.GRAY}/vanish (ver) - Fique invisível no servidor e saiba quem está.")
            sender.sendMessage("${ChatColor.GREEN} ■ ${ChatColor.GRAY}/chapeu - Vista o item ou bloco que estive na mão.")
            sender.sendMessage("${ChatColor.GREEN} ■ ${ChatColor.GRAY}/bigorna - Abre uma bigorna.")
            sender.sendMessage("${ChatColor.GREEN} ■ ${ChatColor.GRAY}/craft - abre uma Crafting Table.")
            sender.sendMessage("${ChatColor.GREEN} ■ ${ChatColor.GRAY}/ender - Abre um Ender Chest.")
            sender.sendMessage("${ChatColor.GREEN} ■ ${ChatColor.YELLOW}/cUtils reload - Irá reiniciar as configurações.")
            sender.sendMessage("")
            val message = net.md_5.bungee.api.chat.TextComponent("${ChatColor.YELLOW} Clique aqui ${ChatColor.GRAY}para mais informações!")
            message.clickEvent = ClickEvent(ClickEvent.Action.OPEN_URL, "https://return-3.gitbook.io/cchat/sobre-o-cchat")
            sender.sendMessage(message)
            sender.sendMessage("")
            return true
        }
        sender.sendMessage("${ChatColor.RED}Use: ${ChatColor.GRAY}/cUtils ajuda ${ChatColor.RED}para ver os comandos disponíveis.")
        return true
    }
}
