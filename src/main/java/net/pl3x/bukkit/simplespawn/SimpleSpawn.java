package net.pl3x.bukkit.simplespawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleSpawn extends JavaPlugin {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Player only command!");
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("simplespawn.command.spawn")) {
            sender.sendMessage(command.getPermissionMessage());
            return true;
        }
        player.teleportAsync(getServer().getWorlds().get(0).getSpawnLocation());
        return true;
    }
}
