[![Build Status](https://travis-ci.org/Suseika/readonly-collections.svg?branch=master)](https://travis-ci.org/Suseika/readonly-collections)

# readonly-collections

Wrappers for Java Collections that let you expose only read-only interfaces 
where you need to.

## Rationale

Java Collections API is flawed in a way that every collection interface has 
mutator methods like `add()`, `remove()` or `put()`. This presents the following 
implications:

### 1. Wrong abstraction

Mutable collections and read-only collections are two completely different sets 
of abstractions. Mutable collections are data structures. Read-only collections 
are mathematical objects: 

- ReadOnlySet is a set;
- ReadOnlyList is function from integers to members of some set;
- ReadOnlyMap is a function from a set of keys to a set of values;

In math texts, when we give a mathematical object a name, like "let set A be 
{x | x > 3 and x < 9} united with {y | y > -2 and y <1}", we don't change 
contents of a math object referred by that name. For instance, we don't add 
elements saying "let set A be the same set A but with one more element k". That 
is similar to the concept of immutability in programming.

Lack of mutators removes unnecessary complexity that would be here if we were to
represent math objects with `java.util.Collection` implementations.

### 2. Lots of unused methods to implement

When you implement a Collection descendant interface (`List`, `Set`) or `Map`, 
you have to provide an implementation for methods like `add()` and `put()`. If 
your collection is not supposed to be mutated (but rather populated at the 
construction time, as for example Guava Collections), then you don't need those 
methods. But you have to provide at least some implementation, so you stub those 
methods with something like:

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

And those methods will still show up in the completion dialog in your IDE and in
the documentation.

