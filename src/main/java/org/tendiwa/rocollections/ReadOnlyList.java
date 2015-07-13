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
package org.tendiwa.rocollections;

/**
 * A list with only accessors and no mutators.
 *
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 */
public interface ReadOnlyList<T> extends ReadOnlyCollection<T> {
    /**
     * Returns an element under particular index.
     *
     * @param index A number in [0;this.size()-1]
     * @return The element under particular index.
     */
    T get(int index);

    @Override
    default boolean contains(T element) {
        final int size = this.size();
        for (int index = 0; index < size; index += 1) {
            if (this.get(index).equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * From the beginning of this list, searches for an element that is equal to
     * {@code element} and returns its index.
     *
     * @param element An object to search for.
     * @return Same as {@link java.util.List#indexOf(Object)}.
     */
    default int indexOf(T element) {
        final int size = this.size();
        for (int index = 0; index < size; index += 1) {
            if (this.get(index).equals(element)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * From the end of this list, searches for an element that is equal to
     * {@code element} and returns its index.
     *
     * @param element An object to search for.
     * @return Same as {@link java.util.List#lastIndexOf(Object)}.
     */
    default int lastIndexOf(T element) {
        final int size = this.size();
        for (int index = size - 1; index >= 0; index -= 1) {
            if (this.get(index).equals(element)) {
                return index;
            }
        }
        return -1;
    }
}
