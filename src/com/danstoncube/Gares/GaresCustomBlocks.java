package com.danstoncube.Gares;

import org.getspout.spoutapi.SpoutManager;

import com.danstoncube.Gares.CustomBlocks.BorneBlock;
import com.danstoncube.Gares.CustomBlocks.Borne.BorneBottomBlock;
import com.danstoncube.Gares.CustomBlocks.Borne.BorneMainBlock;
import com.danstoncube.Gares.CustomBlocks.Borne.BorneTopBlock;

public class GaresCustomBlocks
{
	public static BorneMainBlock borneMainBlock;
	public static BorneTopBlock borneTopBlock;
	public static BorneBottomBlock borneBottomBlock;
	
	
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
		borneTopBlock = new BorneTopBlock();
		borneBottomBlock = new BorneBottomBlock();
		borneMainBlock = new BorneMainBlock();
	}
	
	
	
	
	public static void createRecipes()
	{		
		//SpoutManager.getMaterialManager().registerSpoutRecipe(borneTopBlock.createRecipe());
		//SpoutManager.getMaterialManager().registerSpoutRecipe(borneBottomBlock.createRecipe());
		SpoutManager.getMaterialManager().registerSpoutRecipe(borneMainBlock.createRecipe());
	}
	
	
}
