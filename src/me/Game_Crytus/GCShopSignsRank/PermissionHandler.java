package me.Game_Crytus.GCShopSignsRank;

import org.bukkit.permissions.Permission;

import java.util.ArrayList;
import java.util.List;

public class PermissionHandler {
    private static  GCShop plugin;
    public static List<String> perms = new ArrayList<String>();

    public static void Initialize (GCShop pl) {
        plugin = pl;
        String[] names;

        names = (String[])plugin.getConfig().getConfigurationSection("").getKeys(false).toArray(new String[0]);

        for (String s : names) {
            perms.add(plugin.getConfig().getString(s + ".permission"));
//            plugin.getServer().getConsoleSender().sendMessage("§ePerm: " + (plugin.getConfig().getString(s + ".permission")));
        }

        for (String perm : perms) {
            addPerm(perm);
        }

        GCLogger.infoConsole("All permissions loaded!");
    }

    private static void addPerm(String permNode) {
        if (permNode.equals(null)) {
            return;
        }

        if (permNode.equalsIgnoreCase("null")) {
            return;
        }

        if (permNode.isEmpty()) {
            return;
        }

        for (Permission perms : plugin.getServer().getPluginManager().getPermissions()) {
            if (perms.getName().equalsIgnoreCase(permNode)) {
                return;
            }
        }

        plugin.getServer().getPluginManager().addPermission(new Permission(permNode));
    }
}
