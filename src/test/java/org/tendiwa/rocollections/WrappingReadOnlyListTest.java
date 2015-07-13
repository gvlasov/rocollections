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

import com.google.common.collect.ImmutableList;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.tendiwa.rocollections.test.base.AbstractReadOnlyCollectionTest;
import org.tendiwa.rocollections.test.base.AbstractReadOnlyListTest;

/**
 * Tests a {@link WrappingReadOnlyList} created with an {@link ImmutableList}
 * passed into that static method.
 *
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 */
@RunWith(Enclosed.class)
public final class WrappingReadOnlyListTest {
    /**
     * Provides an instance of {@link ReadOnlyList} for interface tests.
     *
     * @return ReadOnlyList backed by an {@link ImmutableList}.
     */
    private static ReadOnlyList<Object> implInstance() {
        return new WrappingReadOnlyList<>(
            ImmutableList.of(
                new Object(),
                new Object(),
                new Object(),
                new Object(),
                new Object()
            )
        );
    }

    public static class AsList extends AbstractReadOnlyListTest<Object> {
        @Override
        protected final ReadOnlyList<Object> implInstance() {
            return WrappingReadOnlyListTest.implInstance();
        }
    }

    public static class AsCollection extends AbstractReadOnlyCollectionTest<Object> {
        @Override
        protected final ReadOnlyCollection<Object> implInstance() {
            return WrappingReadOnlyListTest.implInstance();
        }
    }
}
