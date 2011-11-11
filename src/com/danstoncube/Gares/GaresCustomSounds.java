package com.danstoncube.Gares;

import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class GaresCustomSounds
{
	public static final String borneOpenUrl = "http://dl.dropbox.com/u/15091039/jingle_sncf.ogg";

	public static void playOpenSound(SpoutPlayer player)
	{
		// TODO Auto-generated method stub
		SpoutManager.getSoundManager().playCustomSoundEffect(Gares.getInstance(), player, GaresCustomSounds.borneOpenUrl, false) ;
		
	}
	
}
