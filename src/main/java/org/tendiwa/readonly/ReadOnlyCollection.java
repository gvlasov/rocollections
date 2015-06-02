package org.tendiwa.readonly;

import java.util.Iterator;
import java.util.stream.Stream;

public interface ReadOnlyCollection<T> extends Iterable<T> {
	boolean contains(T object);

	int size();

	@Override
	Iterator<T> iterator();

	Stream<T> stream();

	default boolean isEmpty() {
		return size() == 0;
	}
}
