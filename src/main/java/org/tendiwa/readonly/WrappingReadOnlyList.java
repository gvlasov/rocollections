package org.tendiwa.readonly;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

final class WrappingReadOnlyList<T> implements ReadOnlyList<T> {
	private final List<T> list;

	WrappingReadOnlyList(List<T> list) {
		this.list = list;
	}

	@Override
	public T get(int index) {
		return list.get(index);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public Stream<T> stream() {
		return list.stream();
	}
}
