package com.danstoncube.Gares;



import org.bukkit.ChatColor;
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
			}			
			else if(popup.isB2(event.getButton()))
			{
				player.chat("/bisoumine");
			}			
			else if(popup.isB3(event.getButton()))
			{
				player.chat("/bisouferme");
			}			
			else if(popup.isB4(event.getButton()))
			{
				player.chat("/farheavens");
			}		
			else
			{
				player.sendMessage(ChatColor.RED + "Station inconnue !");				
			}
			
			popup.close();		
		}
}