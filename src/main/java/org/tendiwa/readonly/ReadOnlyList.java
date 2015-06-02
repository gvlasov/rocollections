package org.tendiwa.readonly;

import java.util.List;

public interface ReadOnlyList<T> extends ReadOnlyCollection<T> {
	T get(int index);

	@Override
	default boolean contains(T o) {
		int size = size();
		for (int i = 0; i < size; i++) {
			if (this.get(i).equals(o)) {
				return true;
			}
		}
		return false;
	}

	default int indexOf(T o) {
		int size = size();
		for (int i = 0; i < size; i++) {
			if (this.get(i).equals(o)) {
				return i;
			}
		}
		return -1;
	}

	default int lastIndexOf(T o) {
		int size = size();
		for (int i = size - 1; i >= 0; i++) {
			if (this.get(i).equals(o)) {
				return i;
			}
		}
		return -1;
	}

	static <T> ReadOnlyList<T> wrapOf(List<T> list) {
		return new WrappingReadOnlyList<>(list);
	}
}
