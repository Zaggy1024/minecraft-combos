package zaggy1024.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zaggy1024.combo.ObjectType;
import zaggy1024.combo.VariantsOfTypesCombo;
import zaggy1024.combo.variant.IMetadata;

/**
 * Generic class to use for combo items, and can be extended if an item doesn't need a specific subclass to Item.
 * 
 * @author Zaggy1024
 */
public class ItemMulti<V extends IMetadata<V>> extends Item
{
	public final VariantsOfTypesCombo<V> owner;
	
	protected final List<V> variants;
	protected final ObjectType<V, ? extends Block, ? extends ItemMulti<V>> type;
	
	public ItemMulti(VariantsOfTypesCombo<V> owner,
			ObjectType<V, ? extends Block, ? extends ItemMulti<V>> type,
			List<V> variants, Class<V> variantClass)
	{
		super();
		
		this.owner = owner;
		this.type = type;
		this.variants = variants;
		
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return owner.getUnlocalizedName(stack, super.getUnlocalizedName(stack));
	}

	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
	{
		owner.fillSubItems(type, variants, subItems);
	}
}
