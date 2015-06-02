import com.google.common.collect.ImmutableList;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.tendiwa.readonly.ReadOnlyCollection;
import org.tendiwa.readonly.ReadOnlyList;
import org.tendiwa.readonly.test.base.ReadOnlyCollectionTest;
import org.tendiwa.readonly.test.base.ReadOnlyListTest;

@RunWith(Enclosed.class)
public final class WrappedListTest {
	public static class AsReadOnlyList extends ReadOnlyListTest<Object> {

		@Override
		protected ReadOnlyList<Object> implInstance() {
			return WrappedListTest.implInstance();
		}
	}

	public static class AsCollection extends ReadOnlyCollectionTest<Object> {

		@Override
		protected ReadOnlyCollection<Object> implInstance() {
			return WrappedListTest.implInstance();
		}
	}

	private static ReadOnlyList<Object> implInstance() {
		return ReadOnlyList.wrapOf(
			ImmutableList.of(
				new Object(),
				new Object(),
				new Object(),
				new Object(),
				new Object()
			)
		);
	}
}
