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
package org.tendiwa.readonly.test.base;

import org.junit.Assert;
import org.junit.Test;
import org.tendiwa.readonly.ReadOnlyList;

/**
 * A base test for {@link ReadOnlyList}s.
 *
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 */
public abstract class AbstractROListTest<T> extends
    AbstractROCollectionTest<T> {

    /**
     * Method {@link ReadOnlyList#get(int)} should return ==-identical result on
     * consecutive invocations.
     */
    @Test
    public final void getReturnsSameElementConsecutively() {
        final ReadOnlyList<T> list = this.implInstance();
        for (int index = 0; index < list.size(); index += 1) {
            Assert.assertSame(list.get(index), list.get(index));
        }
    }

    /**
     * Each index <i>A</i> in a list holds an element whose index is less than
     * or equal to <i>A</i>.
     */
    @Test
    public final void getAndIndexOfMatchIndexwise() {
        final ReadOnlyList<T> list = this.implInstance();
        for (int index = 0; index < list.size(); index += 1) {
            Assert.assertTrue(list.indexOf(list.get(index)) <= index);
        }
    }

    /**
     * Each index <i>A</i> in a list holds an element whose last index is
     * greater than or equal to <i>A</i>.
     */
    @Test
    public final void getAndLastIndexOfMathIndexwise() {
        final ReadOnlyList<T> list = this.implInstance();
        for (int index = list.size() - 1; index >= 0; index -= 1) {
            Assert.assertTrue(list.lastIndexOf(list.get(index)) >= index);
        }
    }

    @Override
    protected abstract ReadOnlyList<T> implInstance();
}
