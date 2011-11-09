package com.danstoncube.plugin.drzoid.Gares;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.event.input.KeyBindingEvent;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.keyboard.BindingExecutionDelegate;
import org.getspout.spoutapi.keyboard.Keyboard;
import org.getspout.spoutapi.player.SpoutPlayer;


@SuppressWarnings("unused")
public class Gares extends JavaPlugin 
{
	private static Gares instance = null;
	
	public static Gares getInstance()
	{
		return instance;
	}

	public void onDisable()
	{
		getServer().getLogger().info("DTC - Gares désactivées");
	}


	public void onEnable()
	{
		getServer().getLogger().info("DTC - Gares activées");
		
		instance = this;
		PluginManager pm = getServer().getPluginManager();
		
		
		//pm.registerEvent(Event.Type.CUSTOM_EVENT, new GaresInputListener(), Priority.Normal, this);
		pm.registerEvent(Event.Type.CUSTOM_EVENT, new GaresScreenListener(), Priority.Normal, this);
		
		
		BindingExecutionDelegate delegate = new BindingExecutionDelegate() 
		{
            
            @Override
            public void keyReleased(KeyBindingEvent event) 
            {
            	event.getPlayer().sendMessage(event.getPlayer().getMainScreen().getScreenType().toString());
            	
            	
            	if(!event.getPlayer().isSpoutCraftEnabled())
            	{
            		event.getPlayer().sendMessage("a pas spout");
            		return;
            	}
            	            	
            	if(event.getPlayer().getMainScreen().getScreenType() != ScreenType.GAME_SCREEN)
            	{
            		return;
            	}
            	
            	if(event.getPlayer().getMainScreen().getActivePopup() == null)
            	{
            		Gares.getInstance().showPopup(event.getPlayer());
            	}
            	
            }
           
            @Override
            public void keyPressed(KeyBindingEvent event) 
            {
            	
            	
            }

			
		};
		
		//Spout.getInstance(). 
		//Spout.getInstance().getServer().
		
		try
		{
			SpoutManager.getKeyBindingManager().registerBinding("toucheG", Keyboard.KEY_G, "DTC - Choix station", delegate, this);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if(sender instanceof ConsoleCommandSender) {
			sender.sendMessage("You must be a player to do that");
			return true;
		}

		if(cmd.getName().equalsIgnoreCase("gares")) 
		{
			Player player = ((Player) sender);
			return doCommand((SpoutPlayer) player, args);
		}
		
		return false;
	}

	private boolean doCommand(SpoutPlayer player, String[] args)
	{
		if(player.isSpoutCraftEnabled())
		{
			showPopup(player);
		}
		
		return true;
	}

	public void showPopup(SpoutPlayer player)
	{
		new GaresPopup(player);		
	}
	

	
}
