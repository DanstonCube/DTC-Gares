package com.danstoncube.Gares.CustomBlocks.Borne;

import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.BlockDesign;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.material.MaterialData;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.danstoncube.Gares.Gares;
import com.danstoncube.Gares.CustomBlocks.BorneBlock;

public class BorneTopBlock extends BorneBlock
{
	SpoutShapedRecipe recipe;
	
	public BorneTopBlock()
	{
		super(Gares.getInstance(), "BorneMainBlock");

		BlockDesign design = new GenericCubeBlockDesign(Gares.getInstance(), BorneBlock.getTexture(), new int[] { 1, 1, 1, 1, 1, 1 });
		//ints are { bottom, north, ?, ?, ?, top }
		this.setBlockDesign(design);	
		this.setItemDrop(new ItemStack(0));
	}

	@SuppressWarnings("deprecation")
	public SpoutShapedRecipe createRecipe()
	{
		String[] shapestring = new String[]{
			"bbb",
			"b b",
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
	}
	
	@Override
	public void onBlockPlace(World paramWorld, int paramInt1, int paramInt2,
			int paramInt3, LivingEntity paramLivingEntity)
	{
	}

	@Override
	public void onBlockPlace(World paramWorld, int paramInt1, int paramInt2,
			int paramInt3)
	{
	}

	

	
	@Override
	public void onBlockDestroyed(World paramWorld, int paramInt1,
			int paramInt2, int paramInt3)
	{
	}

	@Override
	public boolean onBlockInteract(World paramWorld, int paramInt1,
			int paramInt2, int paramInt3, SpoutPlayer paramSpoutPlayer)
	{
		return true;
	}

	@Override
	public void onEntityMoveAt(World paramWorld, int paramInt1, int paramInt2,
			int paramInt3, Entity paramEntity)
	{
	}

	@Override
	public void onBlockClicked(World paramWorld, int paramInt1, int paramInt2,
			int paramInt3, SpoutPlayer paramSpoutPlayer)
	{
	}

	@Override
	public boolean isProvidingPowerTo(World paramWorld, int paramInt1,
			int paramInt2, int paramInt3, BlockFace paramBlockFace)
	{
		return false;
	}

	@Override
	public boolean isIndirectlyProvidingPowerTo(World paramWorld,
			int paramInt1, int paramInt2, int paramInt3,
			BlockFace paramBlockFace)
	{
		return false;
	}



	
}
