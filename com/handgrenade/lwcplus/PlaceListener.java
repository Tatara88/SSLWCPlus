package com.handgrenade.lwcplus;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import com.griefcraft.lwc.LWC;
import com.griefcraft.lwc.LWCPlugin;
import com.griefcraft.model.Protection;

public class PlaceListener implements Listener {

    private List<String> blocks;
    private String msg1;
    private String msg2;
    private FileConfiguration config = null;
    private LWCPlugin lplugin;
			
    public PlaceListener(LWCPlus instance) {
        this.config = instance.getConfig();
        this.blocks = this.config.getStringList("blocked-items");
        this.msg1 = this.config.getString("messages.no-place");
        this.msg2 = this.config.getString("messages.owner-place-warning");
        this.lplugin = (LWCPlugin) Bukkit.getPluginManager().getPlugin("LWC");
    }

    @EventHandler
    public void BlockPlace(BlockPlaceEvent e) {
        LWC lwc = lplugin.getLWC();
        Player p = e.getPlayer();
        Block b = e.getBlockPlaced();
        String pname = p.getName();
    }
       
		if (this.blocks.contains(String.valueOf(b.getType()))) {
      for (Protection protection : lwc.findAdjacentProtectionsOnAllSides(b)) {
	      if (protection != null) {
	        if (!lwc.canAccessProtection(p, protection)) {
	          e.setCancelled(true);
	          p.sendMessage(this.msg1);
	            		
	          Bukkit.broadcast(ChatColor.GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.GRAY + "]" + ChatColor.GREEN + " " + pname +
	    	    ChatColor.GRAY + " has tried to" + ChatColor.YELLOW +  "PLACE" + ChatColor.GRAY +  "a blacklisted item near a LWC locked block!", "lwcplus.notify");
	          }
	            	
	          else if (lwc.canAccessProtection(p, protection)) {
	            p.sendMessage(this.msg2);
	          }
	        }
	      }              
      }	
		}
}
