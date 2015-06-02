package org.tendiwa.readonly;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

final class WrappingReadOnlySet<T> implements ReadOnlySet<T> {
	private final Set<T> set;

	WrappingReadOnlySet(Set<T> set) {
		this.set = set;
	}

	@Override
	public boolean contains(T object) {
		return set.contains(object);
	}

	@Override
	public int size() {
		return set.size();
	}

	@Override
	public Iterator<T> iterator() {
		return set.iterator();
	}

	@Override
	public Stream<T> stream() {
		return set.stream();
	}
}
