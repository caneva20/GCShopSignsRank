package me.Game_Crytus.GCShopSignsRank;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class OnPlace implements Listener {
    @EventHandler
    private void signChange (SignChangeEvent e) {
        Player p = e.getPlayer();

        if (e.getLine(0).equalsIgnoreCase("[RANK SHOP]")) {
            if (p.hasPermission("gcshopsignsrank.sign.create")) {
                e.setLine(0, ChatColor.WHITE + "[" + ChatColor.GOLD + "RANK SHOP" + ChatColor.WHITE + "]");
                p.sendMessage("§aPlaca [RANK SHOP] criada!");
            } else {
                p.sendMessage("§4Você não pode criar uma placa [RANK SHOP]!");
                e.setCancelled(true);
                e.getBlock().breakNaturally();
            }
        }
    }
}
