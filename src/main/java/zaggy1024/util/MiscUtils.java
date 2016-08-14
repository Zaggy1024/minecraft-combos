package zaggy1024.util;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import com.google.common.collect.*;

/**
 * @author Zaggy1024
 */
public final class MiscUtils
{
	/**
	 * Useful for creation of combined sets using Enum.values().
	 */
	@SafeVarargs
	public static <T> Iterable<T> iterable(final T... array)
	{
		return () -> Iterators.forArray(array);
	}
	
	/**
	 * Use to make cheap sets from an array of Enum values.
	 */
	@SafeVarargs
	public static <T extends Enum<T>> Set<T> unmodSet(T... values)
	{
		Set<T> out = EnumSet.noneOf(ReflectionUtils.getClass(values));
		for (T value : values)
			out.add(value);
		return Collections.unmodifiableSet(out);
	}
}
