package zaggy1024.combo;

import zaggy1024.util.BitMask;

/**
 * @author Zaggy1024
 */
public interface IItemMetadataBitMask
{
	/**
	 * Gets the {@link BitMask} for the variant of an item to be stored in its metadata.
	 */
	BitMask getMetadataBitMask();
}
