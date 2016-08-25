package zaggy1024.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

public interface IProxy
{
	Side getSide();
	
	void registerItem(Item item, ResourceLocation name, boolean doModel);
	
	default void registerItem(Item item, ResourceLocation name)
	{
		registerItem(item, name, true);
	}
	
	void registerBlock(Block block, Item item, ResourceLocation name, boolean doModel);
	
	default void registerBlock(Block block, ResourceLocation name, boolean doModel)
	{
		registerBlock(block, new ItemBlock(block), name, doModel);
	}
	
	default void registerBlock(Block block, ResourceLocation name)
	{
		registerBlock(block, name, true);
	}
	
	default void registerBlock(Block block, Item item, ResourceLocation name)
	{
		registerBlock(block, item, name, true);
	}
}
