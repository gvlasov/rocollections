package org.tendiwa.readonly;

import java.util.Set;

public interface ReadOnlySet<T> extends ReadOnlyCollection<T> {
	static <T> ReadOnlySet<T> wrapOf(Set<T> set) {
		return new WrappingReadOnlySet<>(set);
	}
}
