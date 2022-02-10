package com.decay.testes.commands;


import com.decay.testes.Testes;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Commands implements CommandExecutor {
    private final Testes main;

    public Commands(Testes main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            main.getLogger().info("Você precisa ser um jogador para limpar o inventário.");
            return true;
        }
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("clearinv") && (player.isOp() || player.hasPermission("clearinventory"))){
            Inventory inv = player.getInventory();
            inv.clear();
            player.sendMessage(ChatColor.AQUA + "O seu inventário foi limpado.");
        } else if (command.getName().equalsIgnoreCase("clearinv")) {
            player.sendMessage(ChatColor.RED + "Você não possui permissão para limpar o inventário.");
        }
        if (command.getName().equalsIgnoreCase("heal")){
            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxHealth);
            player.sendMessage(ChatColor.AQUA + "A sua vida foi regenerada.");

        }
        if (command.getName().equalsIgnoreCase("feed")){
            player.setFoodLevel(20);
            player.sendMessage(ChatColor.AQUA + "A sua fome foi saciada");
        }
        return true;
    }
}
