package me.Game_Crytus.GCShopSignsRank;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class GCLogger {
    private static Plugin plugin;
    private static String consoleTag = "§f[§6Default TAG§f] ";

    public static void initialize(Plugin pl, String plName) {
        plugin = pl;
        consoleTag = "§f[§6" + plName + "§f] ";

        infoConsole("Logger initialized!");
    }

    public static void log(CommandSender sender, String message) {
        sender.sendMessage(message);
    }

    public static void infoConsole(String message) {
        plugin.getServer().getConsoleSender().sendMessage(consoleTag + "§e" + message);
    }

    public static void warnConsole(String message) {
        plugin.getServer().getConsoleSender().sendMessage(consoleTag + "§c" + message);
    }

    public static void infoNoTag(CommandSender sender, String message) {
        sender.sendMessage("§e" + message);
    }

    public static void warnNoTag(Player player, String message) {
        player.sendMessage("§c" + message);
    }

    public static void debug(String message) {
        plugin.getServer().getConsoleSender().sendMessage("§f[§bDEBUG§f]§b " + message);
    }

}
