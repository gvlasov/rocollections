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
package org.tropinka.readonly;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;
import javax.annotation.Nonnull;

/**
 * Wraps a {@link java.util.Set} with a {@link ReadOnlySet}.
 *
 * @param <T> Type of elements of the collection.
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 */
@SuppressWarnings("unused")
public final class WrappingReadOnlySet<T> implements ReadOnlySet<T> {
    /**
     * The wrapped Set instance.
     */
    private final transient Set<T> set;

    /**
     * Wraps a {@link java.util.Set}.
     *
     * @param wrapped A set to wrap.
     */
    WrappingReadOnlySet(final Set<T> wrapped) {
        this.set = wrapped;
    }

    @Override
    public boolean contains(final T element) {
        return this.set.contains(element);
    }

    /**
     * Size of this set.
     *
     * @return Size of this set.
     */
    @Override
    public int size() {
        return this.set.size();
    }

    /**
     * Iterator over elements of this set.
     *
     * @return Iterator over elements of this set.
     */
    @Nonnull
    @Override
    public Iterator<T> iterator() {
        return this.set.iterator();
    }

    /**
     * Stream over elements of this set.
     *
     * @return Stream over elements of this set.
     */
    @Override
    public Stream<T> stream() {
        return this.set.stream();
    }
}
