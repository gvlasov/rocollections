package org.tendiwa.readonly;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

final class WrappingReadOnlyCollection<T> implements ReadOnlyCollection<T> {
	private final Collection<T> collection;

	public WrappingReadOnlyCollection(Collection<T> collection) {
		this.collection = collection;
	}

	@Override
	public boolean contains(T object) {
		return collection.contains(object);
	}

	@Override
	public int size() {
		return collection.size();
	}

	@Override
	public Iterator<T> iterator() {
		return collection.iterator();
	}

	@Override
	public Stream<T> stream() {
		return collection.stream();
	}
}
