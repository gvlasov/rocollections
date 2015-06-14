/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015, Georgy Vlasov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.tropinka.readonly.test.base;

import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;
import org.tropinka.readonly.ReadOnlyCollection;

/**
 * A base test for {@link ReadOnlyCollection}s.
 *
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 */
public abstract class AbstractROCollectionTest<T> {
    /**
     * May be not empty.
     */
    @Test
    public final void mayBeNotEmpty() {
        final ReadOnlyCollection<T> collection = this.implInstance();
        Assert.assertFalse(collection.isEmpty());
        Assert.assertNotEquals(0, collection.size());
    }

    /**
     * May have size greater than 0.
     */
    @Test
    public final void mayHaveSizeGreaterThanZero() {
        Assert.assertTrue(this.implInstance().size() > 0);
    }

    /**
     * Contains the element that comes first when you iterate over that
     * collection.
     */
    @Test
    public final void containsFirstIteratorResult() {
        final ReadOnlyCollection<T> collection = this.implInstance();
        Assert.assertTrue(
            collection.contains(collection.iterator().next())
        );
    }

    /**
     * Stream made from this collection is over the same elements as an Iterator
     * made from this collection.
     */
    @Test
    public final void streamAccessesSameElementsAsIterator() {
        final ReadOnlyCollection<T> collection = this.implInstance();
        final List<T> copy = collection.stream().collect(Collectors.toList());
        final Iterator<T> iterator = collection.iterator();
        final Iterator<T> copyIterator = copy.iterator();
        while (iterator.hasNext()) {
            Assert.assertEquals(iterator.hasNext(), copyIterator.hasNext());
            Assert.assertEquals(iterator.next(), copyIterator.next());
        }
    }

    /**
     * Iterator has the same number of elements that the collection itself.
     */
    @Test
    public final void interatorSizeMatchesCollectionSize() {
        final ReadOnlyCollection<T> collection = this.implInstance();
        Assert.assertEquals(
            collection.size(),
            Iterators.size(collection.iterator())
        );
    }

    /**
     * Creates an instance of a class to test.
     *
     * @return A new instance of the tetsed implementation.
     */
    protected abstract ReadOnlyCollection<T> implInstance();
}
