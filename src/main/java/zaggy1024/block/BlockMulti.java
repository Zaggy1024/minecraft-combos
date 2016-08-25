package zaggy1024.block;

import java.util.*;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

import zaggy1024.combo.*;
import zaggy1024.combo.VariantsOfTypesCombo.*;
import zaggy1024.combo.variant.IMetadata;
import zaggy1024.combo.variant.PropertyIMetadata;
import zaggy1024.util.*;

/**
 * Generic class to use for combo blocks, and can be extended if an block doesn't need a specific subclass to Block.
 * 
 * @author Zaggy1024
 */
public class BlockMulti<V extends IMetadata<V>> extends Block
{
	/**
	 * Used in {@link VariantsOfTypesCombo}.
	 */
	@BlockProperties
	public static IProperty<?>[] getProperties()
	{
		return new IProperty[]{};
	}
	
	public final VariantsOfTypesCombo<V> owner;
	public final ObjectType<V, ? extends BlockMulti<V>, ? extends Item> type;
	
	public final List<V> variants;
	public final PropertyIMetadata<V> variantProp;
	
	protected final HashSet<V> noItemVariants = new HashSet<>();
	
	public BlockMulti(VariantsOfTypesCombo<V> owner,
			ObjectType<V, ? extends BlockMulti<V>, ? extends Item> type,
			List<V> variants, Class<V> variantClass,
			Material material, SoundType sound)
	{
		super(material);
		
		this.owner = owner;
		this.type = type;
		
		this.variants = variants;
		variantProp = new PropertyIMetadata<>("variant", variants, variantClass);
		
		blockState = new BlockStateContainer(this, variantProp);
		setDefaultState(getBlockState().getBaseState());
		
		setSoundType(sound);
	}
	
	@Override
	public BlockMulti<V> setCreativeTab(CreativeTabs tab)
	{
		super.setCreativeTab(tab);
		return this;
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return BlockStateToMetadata.getMetaForBlockState(state, variantProp);
	}
	
	@Override
	public IBlockState getStateFromMeta(int metadata)
	{
		return BlockStateToMetadata.getBlockStateFromMeta(getDefaultState(), metadata, variantProp);
	}
	
	@Override
	public BlockMulti<V> setUnlocalizedName(String name)
	{
		super.setUnlocalizedName(name);
		return this;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list)
	{
		owner.fillSubItems(type, variants, list);
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		return Collections.singletonList(owner.getStack(type, state.getValue(variantProp)));
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		return owner.getItemMetadata(type, state.getValue(variantProp));
	}
}
