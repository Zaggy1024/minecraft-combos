package zaggy1024.proxy;

import net.minecraftforge.fml.relauncher.*;

@FunctionalInterface
public interface ClientFunction
{
	@SideOnly(Side.CLIENT)
	void apply(ClientProxy client);
}
