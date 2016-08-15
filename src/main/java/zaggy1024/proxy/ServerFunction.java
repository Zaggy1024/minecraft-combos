package zaggy1024.proxy;

import net.minecraftforge.fml.relauncher.*;

@FunctionalInterface
public interface ServerFunction
{
	@SideOnly(Side.SERVER)
	void apply(ServerProxy server);
}
