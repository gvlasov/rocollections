package org.tendiwa.readonly.test.base;

import org.junit.Test;
import org.tendiwa.readonly.ReadOnlyList;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public abstract class ReadOnlyListTest<T> extends ReadOnlyCollectionTest<T> {
	@Override
	protected abstract ReadOnlyList<T> implInstance();

	@Test
	public void get_returns_same_element_consecutively() {
		ReadOnlyList<T> list = implInstance();
		for (int i = 0; i < list.size(); i++) {
			Assert.assertSame(list.get(i), list.get(i));
		}
	}

	@Test
	public void get_and_indexOf_match_indexwise() {
		ReadOnlyList<T> list = implInstance();
		for (int i = 0; i < list.size(); i++) {
			Assert.assertTrue(list.indexOf(list.get(i)) <= i);
		}
	}

	@Test
	public void get_and_lastIndexOf_match_indexwise() {
		ReadOnlyList<T> list = implInstance();
		for (int i = list.size()-1; i >= 0; i++) {
			Assert.assertTrue(list.indexOf(list.get(i)) >= i);
		}
	}
}
