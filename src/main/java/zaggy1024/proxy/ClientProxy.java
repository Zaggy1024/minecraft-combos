package zaggy1024.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public interface ClientProxy extends IProxy
{
	void registerModel(Item item, int metadata, ResourceLocation variantName);
	
	default void registerModel(Item item, ResourceLocation variantName)
	{
		registerModel(item, 0, variantName);
	}
	
	void registerModel(Block item, int metadata, ResourceLocation variantName);
	
	default void registerModel(Block block, ResourceLocation variantName)
	{
		registerModel(block, 0, variantName);
	}
}
