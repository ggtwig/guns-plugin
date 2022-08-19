package com.jack.guns;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Guns implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack netheriteHoe = new ItemStack(Material.NETHERITE_HOE);
            ItemMeta netheriteHoeItemMeta = netheriteHoe.getItemMeta();
            netheriteHoeItemMeta.setDisplayName(ChatColor.DARK_RED + "Panzerfaust");
            netheriteHoe.setItemMeta(netheriteHoeItemMeta);

            ItemStack diamondHoe = new ItemStack(Material.DIAMOND_HOE);
            ItemMeta diamondHoeMeta = diamondHoe.getItemMeta();
            diamondHoeMeta.setDisplayName(ChatColor.AQUA + "Barrett M82");
            diamondHoe.setItemMeta(diamondHoeMeta);

            ItemStack ironHoe = new ItemStack(Material.IRON_HOE);
            ItemMeta ironHoeMeta = ironHoe.getItemMeta();
            ironHoeMeta.setDisplayName(ChatColor.WHITE + "DP-64");
            ironHoe.setItemMeta(ironHoeMeta);

            ItemStack goldenHoe = new ItemStack(Material.GOLDEN_HOE);
            ItemMeta goldenHoeMeta = goldenHoe.getItemMeta();
            goldenHoeMeta.setDisplayName(ChatColor.GOLD + "M16");
            goldenHoe.setItemMeta(goldenHoeMeta);

            ItemStack stoneHoe = new ItemStack(Material.STONE_HOE);
            ItemMeta stoneHoeMeta = stoneHoe.getItemMeta();
            stoneHoeMeta.setDisplayName(ChatColor.GRAY + "Desert Eagle");
            stoneHoe.setItemMeta(stoneHoeMeta);

            ItemStack woodenHoe = new ItemStack(Material.WOODEN_HOE);
            ItemMeta woodenHoeMeta = woodenHoe.getItemMeta();
            woodenHoeMeta.setDisplayName(ChatColor.DARK_PURPLE + "Gloch 17");
            woodenHoe.setItemMeta(woodenHoeMeta);

            ItemStack stick = new ItemStack(Material.STICK);
            ItemMeta stickMeta = stick.getItemMeta();
            stickMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Staff");
            stick.setItemMeta(stickMeta);

            ItemStack magmaCream = new ItemStack(Material.MAGMA_CREAM);
            ItemMeta magmaCreamMeta = magmaCream.getItemMeta();
            magmaCreamMeta.setDisplayName(ChatColor.GREEN + "Medkit");
            magmaCream.setItemMeta(magmaCreamMeta);

            ItemStack blazeRod = new ItemStack(Material.BLAZE_ROD);
            ItemMeta blazeRodMeta = blazeRod.getItemMeta();
            blazeRodMeta.setDisplayName(ChatColor.YELLOW + "Stim Shot");
            blazeRod.setItemMeta(blazeRodMeta);

            player.getInventory().addItem(netheriteHoe, diamondHoe, ironHoe, goldenHoe, stoneHoe, woodenHoe, stick, magmaCream, blazeRod);
        }


        return false;
    }
}
