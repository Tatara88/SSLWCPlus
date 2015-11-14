package com.handgrenade.lwcplus;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class LWCPlus extends JavaPlugin implements Listener {
	LWCPlus plugin;
	
	public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new PlaceListener (this), this);
        this.getServer().getPluginManager().registerEvents(new RightClickListener (this), this);
        this.saveDefaultConfig();
	}
	
	/*
	Figure out how to block auto-placers
	Coloured Code Messages
	*/
	
	public void onDisable () {}
}
