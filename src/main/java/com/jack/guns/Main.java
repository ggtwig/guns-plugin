package com.jack.guns;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public final class Main extends JavaPlugin implements Listener {

    // USES COMMAND /GUNS TO SPAWN IN DIFFERENT GUNS WITH VARYING PROJECTILES:
    // NETHERITE HOE = FIREBALL
    // DIAMOND HOE = TRIDENT
    // IRON HOE = SNOWBALL
    // GOLD HOE = SPECTRAL ARROW
    // STONE HOE = LLAMA SPIT
    // WOODEN HOE = EGG
    // STICK = SHULKER
    // MAGMA CREAM = SPLASH HEAL POTION
    // BLAZE ROD SPLASH SPEED POTION

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getCommand("guns").setExecutor(new Guns());
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        if (e.getHand().equals(EquipmentSlot.HAND)) {
            Player player = e.getPlayer();
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Panzerfaust")) {
                    player.launchProjectile(Fireball.class, player.getLocation().getDirection());
                } else if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Barrett M82")) {
                    player.launchProjectile(Trident.class, player.getLocation().getDirection());
                } else if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "DP-64")) {
                    player.launchProjectile(Snowball.class, player.getLocation().getDirection());
                } else if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "M16")) {
                    player.launchProjectile(SpectralArrow.class, player.getLocation().getDirection());
                } else if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Desert Eagle")) {
                    player.launchProjectile(LlamaSpit.class, player.getLocation().getDirection());
                } else if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Gloch 17")) {
                    player.launchProjectile(Egg.class, player.getLocation().getDirection());
                } else if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Staff")) {
                    player.launchProjectile(ShulkerBullet.class, player.getLocation().getDirection());
                } else if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Medkit")) {
                    // CREATING HEALTH POTION
                    ItemStack splashHealthPotion = new ItemStack(Material.SPLASH_POTION);
                    PotionMeta splashHealthPotionMeta = (PotionMeta) splashHealthPotion.getItemMeta();
                    splashHealthPotionMeta.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL, false, true));
                    splashHealthPotion.setItemMeta(splashHealthPotionMeta);

                    ThrownPotion healthPotion = player.launchProjectile(ThrownPotion.class, player.getLocation().getDirection());
                    healthPotion.setItem(splashHealthPotion);
                } else if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Stim Shot")) {
                    // CREATING SPEED POTION
                    ItemStack splashSpeedPotion = new ItemStack(Material.SPLASH_POTION);
                    PotionMeta splashSpeedPotionMeta = (PotionMeta) splashSpeedPotion.getItemMeta();
                    splashSpeedPotionMeta.setBasePotionData(new PotionData(PotionType.SPEED, false, true));
                    splashSpeedPotion.setItemMeta(splashSpeedPotionMeta);

                    ThrownPotion speedPotion = player.launchProjectile(ThrownPotion.class, player.getLocation().getDirection());
                    speedPotion.setItem(splashSpeedPotion);
                }
            }
        }

    }



    @EventHandler
    public void onPlayerEggThrow(PlayerEggThrowEvent e) {

        e.setHatching(false);

    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        Projectile abstractArrow = e.getEntity();
        if (abstractArrow instanceof AbstractArrow) {
            ((AbstractArrow) abstractArrow).setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
        }
    }

}
