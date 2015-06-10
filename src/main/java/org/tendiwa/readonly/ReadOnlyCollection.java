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
package org.tendiwa.readonly;

import java.util.stream.Stream;

/**
 * A collection without mutators, only with accessors.
 *
 * @param <T> Type of elements of the collection.
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 */
public interface ReadOnlyCollection<T> extends Iterable<T> {
    /**
     * Checks if this ReadOnlyCollection contains a particular object with the
     * same rules as {@link java.util.Collection#contains(Object)}.
     *
     * @param object An object to search for.
     * @return True if object is present in collection, false otherwise.
     */
    boolean contains(T object);

    /**
     * Size of this collection.
     *
     * @return Number of elements in this collection.
     */
    int size();

    /**
     * Stream over elements of this collection.
     *
     * @return Stream over elements of this collection.
     */
    Stream<T> stream();

    /**
     * Checks if this collection is empty.
     *
     * @return True if the collection is empty, false if there are any elements.
     */
    default boolean isEmpty() {
        return this.size() == 0;
    }
}
