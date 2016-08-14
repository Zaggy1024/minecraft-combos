package zaggy1024.combo;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

/**
 * A functional interface for callbacks to modify a block's values after certain events.
 * 
 * @author Zaggy1024
 */
@FunctionalInterface
public interface ObjectFunction<B extends Block, I extends Item>
{
	void apply(B block, I item);
}
