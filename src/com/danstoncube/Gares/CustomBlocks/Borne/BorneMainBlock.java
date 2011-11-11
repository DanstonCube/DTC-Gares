package com.danstoncube.Gares.CustomBlocks.Borne;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.BlockDesign;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.material.MaterialData;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.danstoncube.Gares.Gares;
import com.danstoncube.Gares.GaresCustomBlocks;
import com.danstoncube.Gares.GaresCustomSounds;
import com.danstoncube.Gares.CustomBlocks.BorneBlock;

public class BorneMainBlock extends GenericCustomBlock
{
	SpoutShapedRecipe recipe;
	
	public BorneMainBlock()
	{
		
		super(Gares.getInstance(), "BorneMainBlock");

		Bukkit.getServer().getLogger().info("BorneMainBlock");
		
		BlockDesign design = new GenericCubeBlockDesign(Gares.getInstance(), BorneBlock.getTexture(), new int[] { 1, 0, 0, 0, 0, 1 });
		//ints are { bottom, north, ?, ?, ?, top }
		this.setBlockDesign(design);		
	}

	@SuppressWarnings("deprecation")
	public SpoutShapedRecipe createRecipe()
	{
		String[] shapestring = new String[]{
			"b b",
			"bbb",
			"b b"
		};
		
		ItemStack itemStack = SpoutManager.getMaterialManager().getCustomItemStack(this, 1);
		
		recipe = new SpoutShapedRecipe(itemStack);
		recipe.shape(shapestring).setIngredient('b', MaterialData.bedrock);		
		return recipe;
	}
	

	@Override
	public void onNeighborBlockChange(World paramWorld, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4)
	{
		//TODO: Tester si on a peter un pilier ou le toit ? 
	}
	
	
	@Override
	public void onBlockPlace(World paramWorld, int paramInt1, int paramInt2,
			int paramInt3, LivingEntity paramLivingEntity)
	{
		Bukkit.getServer().getLogger().info("THIS EVENT IS NEVER FIRED");
	}
	
	@Override
	public void onBlockPlace(World paramWorld, int paramInt1, int paramInt2,
			int paramInt3)
	{
		
		Bukkit.getServer().getLogger().info("THIS ANOTHER ONE ALSO");
		
		
		
		//TODO: checker les blocks au dessus et en dessous,
		//et poser les bloc "pilier" et / ou "toit" si possible
		
		
		
		Block b = (Block) this;
		Block relativeTop = b.getRelative(0, 1, 0);
		Block relativeBottom = b.getRelative(0, -1, 0);
		
		
		Bukkit.getServer().getLogger().info(String.valueOf(relativeTop.getTypeId()));
		Bukkit.getServer().getLogger().info(String.valueOf(relativeBottom.getTypeId()));
		
		if(relativeTop.getTypeId() == 0)
		{
			relativeTop.setTypeId(GaresCustomBlocks.borneTopBlock.getCustomId());
		}
		
		if(relativeBottom.getTypeId() == 0)
		{
			relativeBottom.setTypeId(GaresCustomBlocks.borneBottomBlock.getCustomId());
		}
		
		//(onblockplace) (Block) block.getRelative(0, -1, 0).setTypeId(mycustomBlock.getCustomId());
		
	}

	

	
	@Override
	public void onBlockDestroyed(World paramWorld, int paramInt1,
			int paramInt2, int paramInt3)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public boolean onBlockInteract(World paramWorld, int paramInt1,
			int paramInt2, int paramInt3, SpoutPlayer paramSpoutPlayer)
	{

		GaresCustomSounds.playOpenSound(paramSpoutPlayer);
		
		Gares.getInstance().showMenu(paramSpoutPlayer);
		
		return true;
	}

	@Override
	public void onEntityMoveAt(World paramWorld, int paramInt1, int paramInt2,
			int paramInt3, Entity paramEntity)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void onBlockClicked(World paramWorld, int paramInt1, int paramInt2,
			int paramInt3, SpoutPlayer paramSpoutPlayer)
	{
		//On check qu'il tappe a la main pour ouvrir la fenetre (sinon on peut pas péter le bloc a cause du popup)
		if(paramSpoutPlayer.getItemInHand().getType() != Material.AIR)
			return;
		
		
		GaresCustomSounds.playOpenSound(paramSpoutPlayer);
		
		Gares.getInstance().showMenu(paramSpoutPlayer);
	}

	@Override
	public boolean isProvidingPowerTo(World paramWorld, int paramInt1,
			int paramInt2, int paramInt3, BlockFace paramBlockFace)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIndirectlyProvidingPowerTo(World paramWorld,
			int paramInt1, int paramInt2, int paramInt3,
			BlockFace paramBlockFace)
	{
		// TODO Auto-generated method stub
		return false;
	}





	
}
