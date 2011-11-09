package com.danstoncube.plugin.drzoid.Gares;

import org.getspout.spoutapi.event.input.InputListener;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.event.input.KeyReleasedEvent;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.keyboard.Keyboard;

public class GaresInputListener extends InputListener
{
    @Override
    public void onKeyPressedEvent(KeyPressedEvent event) 
    {
    	if(!event.getPlayer().isSpoutCraftEnabled())
    		return;
    	
    	if(event.getScreenType().compareTo(ScreenType.GAME_SCREEN)!=0)
    		return;
    	
    	if(event.getKey().compareTo(Keyboard.KEY_G)!=0)
	    	return;
    	
    	//Gares.getInstance().hidePopup(event.getPlayer());
    }
    
    

    @Override
    public void onKeyReleasedEvent(KeyReleasedEvent event) 
    {
    	if(!event.getPlayer().isSpoutCraftEnabled())
    		return;
    	
    	if(event.getScreenType().compareTo(ScreenType.GAME_SCREEN)!=0)
    		return;
    	
    	if(event.getKey().compareTo(Keyboard.KEY_G)!=0)
	    	return;
    	

		Gares.getInstance().showPopup(event.getPlayer());
    }
}
