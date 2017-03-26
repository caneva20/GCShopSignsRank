package me.Game_Crytus.GCShopSignsRank;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OnBreak implements Listener {
    @EventHandler
    private void onBreakBlock (BlockBreakEvent e) {
        Block b = e.getBlock();
        Player p = e.getPlayer();

        Block[] blocks = new Block[6];
        blocks[0] = b;
        blocks[1] = b.getRelative(BlockFace.WEST);
        blocks[2] = b.getRelative(BlockFace.NORTH);
        blocks[3] = b.getRelative(BlockFace.EAST);
        blocks[4] = b.getRelative(BlockFace.SOUTH);
        blocks[5] = b.getRelative(BlockFace.UP);

        for (int i = 0; i < 6; i++) {
            if (blocks[i].getType() == Material.SIGN_POST || blocks[i].getType() == Material.WALL_SIGN) {
                Sign sign = (Sign) blocks[i].getState();
                String text = sign.getLine(0);

                if (ChatColor.stripColor(text).equalsIgnoreCase("[RANK SHOP]")) {
                    if (!p.hasPermission("gcshopsignsrank.sign.break")) {
                        e.setCancelled(true);
                        if (i == 0) {
                            p.sendMessage("§4Você não pode quebrar esta placa!");
                        } else {
                            p.sendMessage("§4Você não pode quebrar este bloco!");
                        }

                        break;
                    }
                }
            }
        }

    }
}
