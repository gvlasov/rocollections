package org.tendiwa.readonly.test.base;

import org.junit.Assert;
import org.junit.Test;
import org.tendiwa.readonly.ReadOnlyCollection;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public abstract class ReadOnlyCollectionTest<T> {
	protected abstract ReadOnlyCollection<T> implInstance();

	@Test
	public void may_be_not_empty() {
		ReadOnlyCollection<T> collection = implInstance();
		Assert.assertFalse(collection.isEmpty());
		Assert.assertNotEquals(0, collection.size());
	}

	@Test
	public void may_have_size_greater_than_0() {
		Assert.assertTrue(implInstance().size() > 0);
	}

	@Test
	public void contains_first_iterator_result() {
		ReadOnlyCollection<T> collection = implInstance();
		Assert.assertTrue(
			collection.contains(collection.iterator().next())
		);
	}

	@Test
	public void stream_accesses_same_elements_as_iterator() {
		ReadOnlyCollection<T> collection = implInstance();
		List<T> copy = collection.stream().collect(Collectors.toList());
		Iterator<T> iterator = collection.iterator();
		Iterator<T> copyIterator = copy.iterator();
		while (iterator.hasNext()) {
			Assert.assertEquals(iterator.hasNext(), copyIterator.hasNext());
			Assert.assertEquals(iterator.next(), copyIterator.next());
		}
	}

	@Test
	public void interator_size_matches_collection_size() {
		ReadOnlyCollection<T> collection = implInstance();
		Iterator<T> iterator = collection.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			i++;
			iterator.next();
		}
		Assert.assertEquals(
			collection.size(),
			i
		);
	}
}