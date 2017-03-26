package me.Game_Crytus.GCShopSignsRank;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RanksManager {
    public static GCShop plugin;
    private static List<RankItem> rankItems = new ArrayList<RankItem>();

    public static void initialize (GCShop pl) {
        plugin = pl;
        String[] names = (String[])plugin.getConfig().getConfigurationSection("").getKeys(false).toArray(new String[0]);

        String pattern = "(\\d+):?(\\d*); ?(\\d+\\.?\\d*)";
        for (String s : names) {
            List<String> items = plugin.getConfig().getStringList(s + ".items");

            for (String ss : items) {
                String id = ss.replaceAll(pattern, "$1");
                String data = ss.replaceAll(pattern, "$2");
                String price = ss.replaceAll(pattern, "$3");

                GCLogger.debug("ID: " + id);
                GCLogger.debug("Data: " + data);
                GCLogger.debug("Price: " + price);
                GCLogger.debug("----------------------");

                rankItems.add(new RankItem(Integer.parseInt(id), Integer.parseInt(data), Double.parseDouble(price)));
            }
        }
    }
}
