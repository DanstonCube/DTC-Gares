package com.danstoncube.plugin.drzoid.Gares;



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
			
			//player.
			
			GaresPopup popup = (GaresPopup) player.getMainScreen().getActivePopup();
			
			
			if(popup.isB1(event.getButton()))
			{
				player.sendMessage("B1");
			}			
			else if(popup.isB2(event.getButton()))
			{
				player.sendMessage("B2");
			}			
			else if(popup.isB3(event.getButton()))
			{
				player.sendMessage("B3");
			}			
			else if(popup.isB4(event.getButton()))
			{
				player.sendMessage("B4");
			}		
			else
			{
				player.sendMessage("b???");
				
			}
			
			popup.close();

			player.getMainScreen().closePopup();
			//Bukkit.getServer().getPluginCommand("");
			//player
		}
}