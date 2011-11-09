package com.danstoncube.plugin.drzoid.Gares;

import java.util.UUID;


import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.Container;
import org.getspout.spoutapi.gui.ContainerType;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericContainer;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

@SuppressWarnings("unused")
public class GaresPopup extends GenericPopup
{
	
	private final UUID b1ID;
	private final UUID b2ID;
	private final UUID b3ID;
	private final UUID b4ID;
	
	final Plugin gares = Gares.getInstance();
		
	

	GaresPopup(SpoutPlayer sPlayer) 
	{
		Container box = new GenericContainer();

		
		
		int widthScale = sPlayer.getMainScreen().getWidth() / 100;
		int heightScale = sPlayer.getMainScreen().getHeight() / 100;

		GenericButton mineButton = new GenericButton("Mine");
		mineButton.setAlign(WidgetAnchor.CENTER_CENTER);
		mineButton.setAnchor(WidgetAnchor.CENTER_CENTER);
		mineButton.setHoverColor(new Color(0, 255, 0));

		GenericButton scierieButton = new GenericButton("Scierie / Ferme");
		scierieButton.setAlign(WidgetAnchor.CENTER_CENTER);
		scierieButton.setAnchor(WidgetAnchor.CENTER_CENTER);
		scierieButton.setHoverColor(new Color(0, 255, 0));

		
		GenericButton fhButton = new GenericButton("Farheavens");
		fhButton.setAlign(WidgetAnchor.CENTER_CENTER);
		fhButton.setAnchor(WidgetAnchor.CENTER_CENTER);
		fhButton.setHoverColor(new Color(0, 255, 0));
		
		GenericButton spawnButton = new GenericButton("Spawn de Bisounours");
		spawnButton.setAlign(WidgetAnchor.CENTER_CENTER);
		spawnButton.setAnchor(WidgetAnchor.CENTER_CENTER);
		spawnButton.setHoverColor(new Color(0, 255, 0));
		
		GenericTexture texture = new GenericTexture();
		texture.setUrl("http://dl.dropbox.com/u/15091039/dtclogo.png"); 	//Have to be a png or jpg
		texture.setAnchor(WidgetAnchor.CENTER_LEFT);
		texture.setWidth(62).setHeight(62); 								//Use the same size as the png here.
		
		
		box.addChildren(texture, mineButton, scierieButton, fhButton, spawnButton);
		
	
		
		
		box.setLayout(ContainerType.VERTICAL);
		box.setAnchor(WidgetAnchor.CENTER_CENTER);
		box.setWidth(widthScale * 50).setHeight(heightScale * 50);
		box.shiftYPos(-(box.getHeight()/2));
		box.shiftXPos(-spawnButton.getWidth()/2);

		this.setTransparent(true);
		this.attachWidget(gares, box);

		b1ID = spawnButton.getId();
		b2ID = mineButton.getId();
		b3ID = scierieButton.getId();
		b4ID = fhButton.getId();
		
		/*
		GenericLabel label = new GenericLabel("Choisissez le prochain arrêt");
		label.setAlign(WidgetAnchor.CENTER_CENTER);
		label.setAnchor(WidgetAnchor.CENTER_CENTER);

		this.attachWidget(gares, label);
		*/
		 
		//this.
		sPlayer.getMainScreen().attachPopupScreen(this);
	}

	public boolean isB1(Button button) {
		return button.getId().equals(b1ID);
	}

	public boolean isB2(Button button) {
		return button.getId().equals(b2ID);
	}
	
	public boolean isB3(Button button) {
		return button.getId().equals(b3ID);
	}

	public boolean isB4(Button button) {
		return button.getId().equals(b4ID);
	}

}

