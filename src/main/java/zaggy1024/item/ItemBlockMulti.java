package zaggy1024.item;

import java.util.*;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import zaggy1024.combo.*;
import zaggy1024.combo.variant.IMetadata;
import zaggy1024.common.GenesisCreativeTabs;

/**
 * Generic class to use for combo blocks, and can be extended if a block doesn't need a specific subclass to ItemBlock.
 * 
 * @author Zaggy1024
 */
public class ItemBlockMulti<V extends IMetadata<V>> extends ItemBlock
{
	public final VariantsOfTypesCombo<V> owner;
	public final ObjectType<V, ? extends Block, ? extends ItemBlockMulti<V>> type;
	
	protected final List<V> variants;
	
	public ItemBlockMulti(Block block, VariantsOfTypesCombo<V> owner,
			ObjectType<V, ? extends Block, ? extends ItemBlockMulti<V>> type,
			List<V> variants, Class<V> variantClass)
	{
		super(block);
		
		this.owner = owner;
		this.type = type;
		
		this.variants = variants;
		
		setHasSubtypes(true);
		
		setCreativeTab(GenesisCreativeTabs.BLOCK);
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> subItems)
	{
		super.getSubItems(item, tab, subItems);
	}
	
	/*@Override
	public int getColorFromItemStack(ItemStack stack, int renderPass)
	{
		return getBlock().getRenderColor(owner.getBlockState(type, owner.getVariant(stack)));
	}*/
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return owner.getUnlocalizedName(stack, super.getUnlocalizedName(stack));
	}
	
	@Override
	public int getMetadata(int damage)
	{
		return damage;
	}
}
