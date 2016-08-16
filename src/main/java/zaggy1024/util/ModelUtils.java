package zaggy1024.util;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ModelUtils
{
	public static ModelResourceLocation getItemModelLocation(ResourceLocation variantName)
	{
		return new ModelResourceLocation(variantName, "inventory");
	}
	
	public static void registerModel(Item item, int metadata, ResourceLocation variantName)
	{
		ModelLoader.setCustomModelResourceLocation(item, metadata, getItemModelLocation(variantName));
		ModelBakery.registerItemVariants(item, variantName);
	}
	
	public static void registerModel(Item item, ResourceLocation variantName)
	{
		registerModel(item, 0, variantName);
	}
	
	public static void registerModel(Block block, int metadata, ResourceLocation variantName)
	{
		Item item = Item.getItemFromBlock(block);
		
		if (item != null)
		{
			registerModel(item, metadata, variantName);
		}
	}
	
	public static void registerModel(Block block, ResourceLocation variantName)
	{
		registerModel(block, 0, variantName);
	}
}
