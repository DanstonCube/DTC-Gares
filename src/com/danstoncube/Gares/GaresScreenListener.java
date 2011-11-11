package com.danstoncube.Gares;




import org.bukkit.ChatColor;
import org.bukkit.Material;

import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenListener;
import org.getspout.spoutapi.player.SpoutPlayer;

public class GaresScreenListener extends ScreenListener 
{


		/**
		 * Handles a button click event
		 *
		 * @param event the event
		 */
		@Override
		public void onButtonClick(ButtonClickEvent event) 
		{
			SpoutPlayer player = event.getPlayer();
			
			GaresPopup popup = (GaresPopup) player.getMainScreen().getActivePopup();
			
			if(popup.isB1(event.getButton()))
			{
				player.chat("/bisougare");
				player.sendNotification("Choix gare", "Spawn de Bisounours !", Material.RAILS);
			}			
			else if(popup.isB2(event.getButton()))
			{
				player.chat("/bisoumine");
				player.sendNotification("Choix gare", "Mine publique", Material.RAILS);
			}			
			else if(popup.isB3(event.getButton()))
			{
				player.chat("/bisouferme");
				player.sendNotification("Choix gare", "Ferme / scierie", Material.RAILS);
			}			
			else if(popup.isB4(event.getButton()))
			{
				player.chat("/farheavens");
				player.sendNotification("Choix gare", "Farheavens", Material.RAILS);
			}		
			else
			{
				player.sendMessage(ChatColor.RED + "Station inconnue !");
			}
			//Material.RAILS.
			popup.close();		
		}
}