package zaggy1024.util;

import java.lang.reflect.Constructor;

import org.apache.commons.lang3.ClassUtils;

/**
 * @author Zaggy1024
 */
public class ReflectionUtils
{
	/**
	 * Gets the constructor for a class, checking for all superclasses to the classes of the {@code invokeArgs}.
	 */
	public static <T> Constructor<T> getConstructor(Class<T> clazz, Object[] invokeArgs)
	{
		for (Constructor<?> declared : clazz.getConstructors())
		{
			Constructor<T> constructor = null;
			
			try
			{
				constructor = clazz.getConstructor(declared.getParameterTypes());
			}
			catch (NoSuchMethodException e) {}
			
			if (constructor != null)
			{
				Class<?>[] constructorTypes = constructor.getParameterTypes();
				
				if (constructorTypes.length == invokeArgs.length)
				{
					boolean correct = true;
					
					for (int i = 0; i < invokeArgs.length; i++)
					{
						Class<?> constructorClass = constructorTypes[i];
						Class<?> invokeClass = invokeArgs[i].getClass();
						
						if (!ClassUtils.isAssignable(invokeClass, constructorClass))
						{
							correct = false;
							break;
						}
					}
					
					if (correct)
						return constructor;
				}
			}
		}
		
		throw new RuntimeException(new NoSuchMethodException(clazz.getName() + " has no constructor with parameters " + Stringify.stringifyArray(invokeArgs) + "."));
	}
	
	/**
	 * Constructs the class using the provided arguments, using the same behavior as {@link ReflectionUtils#getConstructor}
	 * to match the arguments.
	 */
	public static <T> T construct(Class<T> clazz, Object[] args)
	{
		try
		{
			return getConstructor(clazz, args).newInstance(args);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Used to convert a class from Class<Thing> to Class<Thing<Other>> when necessary for creation of a combo.
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> convertClass(Class<? super T> clazz)
	{
		return (Class<T>) clazz;
	}
	
	@SuppressWarnings("unchecked")
	@SafeVarargs
	public static <T> Class<T> getClass(T... array)
	{
		return (Class<T>) array.getClass().getComponentType();
	}
	
	/**
	 * Returns null if {@code clazz} is null, otherwise casts the {@code value} to the provided class.
	 */
	public static <T> T nullSafeCast(Class<T> clazz, Object value)
	{
		return clazz == null ? null : clazz.cast(value);
	}
}
