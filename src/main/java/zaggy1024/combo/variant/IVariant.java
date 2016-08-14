package zaggy1024.combo.variant;

import net.minecraft.util.IStringSerializable;

/**
 * An interface with {@code getName()} and {@code getUnlocalizedName} for use in naming variants in combos.
 */
public interface IVariant extends IStringSerializable
{
	String getUnlocalizedName();
}
