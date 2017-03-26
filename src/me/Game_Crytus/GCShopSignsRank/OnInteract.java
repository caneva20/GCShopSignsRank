package me.Game_Crytus.GCShopSignsRank;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class OnInteract implements Listener {
    private GCShop plugin;

    public  OnInteract (GCShop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerInteract (PlayerInteractEvent e) {
        Block b = e.getClickedBlock();
        Player p = e.getPlayer();



        if (b == null) {return;}

        if (b.getType() == Material.SIGN_POST || b.getType() == Material.WALL_SIGN) {
            if (p.hasPermission("gcshopsignsrank.sign.interact")) {
                Sign sign = (Sign)b.getState();
                String text = sign.getLine(0);

                if (ChatColor.stripColor(text).equalsIgnoreCase("[RANK SHOP]")) {
                    if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {

                    } else if (e.getAction() == Action.LEFT_CLICK_BLOCK) {

                    }
                }
            } else if (p.hasPermission("gcshopsignsrank.sign.use")) {

            }
        }
    }
}
