package com.danstoncube.Gares;

import org.bukkit.ChatColor;
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


public class Gares extends JavaPlugin 
{
	private static Gares instance = null;
	
	public static Gares getInstance()
	{
		return instance;
	}

	public void onDisable()
	{
		getServer().getLogger().info("DTC - Gares désactivés");
	}


	public void onEnable()
	{
		
		
		instance = this;
		PluginManager pm = getServer().getPluginManager();
		
		
		pm.registerEvent(Event.Type.CUSTOM_EVENT, new GaresScreenListener(), Priority.Normal, this);
		
		
		BindingExecutionDelegate delegate = new BindingExecutionDelegate() 
		{
            @Override
            public void keyReleased(KeyBindingEvent event) 
            {
            	
            	if((event.getPlayer().getActiveScreen() != ScreenType.CUSTOM_SCREEN && event.getPlayer().getActiveScreen() != ScreenType.GAME_SCREEN))
            	{
            		return;
            	}
            	
            	if(event.getPlayer().getMainScreen().getActivePopup() != null)
            	{
            		return;
            	}
            	
            	
            	Gares.getInstance().showPopup(event.getPlayer());
            }
           
            @Override
            public void keyPressed(KeyBindingEvent event) 
            {
            }
        };
			
		try
		{
			SpoutManager.getKeyBindingManager().registerBinding("touche_gares", Keyboard.KEY_G, "DTC - Choix station", delegate, this);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		//Custom blocks =)
		GaresCustomBlocks.precacheTextures();
		GaresCustomBlocks.loadTextures();
		GaresCustomBlocks.createBlocks();
		GaresCustomBlocks.createRecipes();
		
		getServer().getLogger().info("DTC - Gares activés");
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if(sender instanceof ConsoleCommandSender) {
			sender.sendMessage("You must be a player to do that");
			return true;
		}

		if(cmd.getName().equalsIgnoreCase("gares")) 
		{
			Player player = ((Player) sender);
			return garesCommand((SpoutPlayer) player, args);
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void showMenu(SpoutPlayer player)
	{
		if(player.isSpoutCraftEnabled())
		{
			showPopup(player);
		}
		else
		{
			showTextMenu(player);
		}
	}
	
	
	public void showTextMenu(SpoutPlayer player)
	{
		player.sendMessage(ChatColor.BLUE + "Liste des stations de Bisounours: ");
		player.sendMessage(ChatColor.DARK_BLUE + "/bisoumine" + ChatColor.WHITE + " -> Mine publique");
		player.sendMessage(ChatColor.DARK_BLUE + "/bisouferme" + ChatColor.WHITE + " -> Ferme et scierie publique");
		player.sendMessage(ChatColor.DARK_BLUE + "/bisougare" + ChatColor.WHITE + " -> Spawn de Bisounours");
		player.sendMessage(ChatColor.DARK_BLUE + "/farheavens" + ChatColor.WHITE + " -> Farheavens");		
	}

	

	private boolean garesCommand(SpoutPlayer player, String[] args)
	{
		showMenu(player);
		return true;
	}

	public void showPopup(SpoutPlayer player)
	{
		new GaresPopup(player);		
	}
	

	
}
