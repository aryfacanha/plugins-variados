package com.decay.testes;

import com.decay.testes.commands.Commands;
import com.decay.testes.events.BreakBlock;
import com.decay.testes.events.PlayerJoin;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Testes extends JavaPlugin {

    @Override
    public void onEnable() {
        Commands commands = new Commands(this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new BreakBlock(), this);
        getCommand("clearinv").setExecutor(commands);
        getCommand("heal").setExecutor(commands);
        getCommand("feed").setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Plugins funcionando");

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Plugins desfuncionando");
    }
}
