package com.danstoncube.Gares.CustomBlocks;

import org.getspout.spoutapi.block.design.Texture;
import com.danstoncube.Gares.Gares;

public class BorneBlock
{
	private static Texture _texture;
	
	
	public final static String texture_url = "http://dl.dropbox.com/u/15091039/texture_test.png";
	
	
	
	
	public static void createTexture()
	{
		_texture = new Texture(Gares.getInstance(), texture_url, 4096, 4096, 256);
	}
	
	public static Texture getTexture()
	{
		return _texture;
	}
	
}
