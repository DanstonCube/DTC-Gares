package com.danstoncube.Gares;

import org.getspout.spoutapi.SpoutManager;

import com.danstoncube.Gares.CustomBlocks.BorneBlock;
import com.danstoncube.Gares.CustomBlocks.Borne.BorneMainBlock;

public class GaresCustomBlocks
{
	public static BorneMainBlock borneMainBlock;
	
	
	public static void precacheTextures()
	{
		SpoutManager.getFileManager().addToPreLoginCache(Gares.getInstance(), BorneBlock.texture_url);
	}
	
	public static void loadTextures()
	{
		BorneBlock.createTexture();
	}
	
	
	public static void createBlocks()
	{
		borneMainBlock = new BorneMainBlock();
	}
	
	
	
	
	public static void createRecipes()
	{
		SpoutManager.getMaterialManager().registerSpoutRecipe(borneMainBlock.createRecipe());
	}
	
	
}
