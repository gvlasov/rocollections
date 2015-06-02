# readonly-collections

Java Collections alternative that can be read, but can't be written to.

## Rationale

Java Collections API is flawed in a way that every collection interface is mutable. This presents the following 
implications:

### 1. Lots of unused methods to implement

When you implement a Collection descendant interface (`List`, `Set`) or `Map`, you have to provide an 
implementation for methods like `add()` and `put()`. If your collection is not supposed to be mutated (but rather 
populated at the construction time, as for example Guava Collections), then you don't need those methods. But you 
have to provide at least some implementation, so you stub those methods with something like:

```java
public class Polygon implements List<Point2D> {
//...
    @Deprecated
    @Override
    public void add(Point2D point) {
        throw new UnsupportedOperationException();
    }
}
```

And those methods will still show up in the completion dialog in your IDE and in the documentation.

If you want proper read-only collections, then you just shouldn't even have those methods in your interface in the 
first place. That is, you shouldn't be using the Java Collection API interfaces. That is, you should be using 
**readonly-collections**

### 2. 
When in some algorithm implementation you have a mutable collection that is populated with the results of that 
algorithm, then in order to return the results you have to either return the mutable `Collection` (gross!), wrap it 
in a Guava Immutable Collection (may be costly).

```java
public class RasterizedPolygonGroup extends ReadableSet<Raster> {
    RasterizedPolygonGroup(
        ReadOnlyCollection polygons
    ) {
        
    }
}
```

## Why the hell would I ever want to subclass a Collection?



## Alternatives to readonly-collections

Google Guava provides a truly immutable set of implementations that is compatible with Java Collections API, but it 
has the following issues:

1. There are still the mutator methods, just marked as `@Deprecated`
2. You can't extend any of the immutable collections implementations.