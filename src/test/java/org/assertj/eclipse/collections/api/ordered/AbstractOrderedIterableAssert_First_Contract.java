package org.assertj.eclipse.collections.api.ordered;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.api.ObjectAssert;
import org.eclipse.collections.api.ordered.OrderedIterable;
import org.junit.jupiter.api.Test;

public interface AbstractOrderedIterableAssert_First_Contract<ELEMENT, I extends OrderedIterable<ELEMENT>, A extends AbstractOrderedIterableAssert<A, I, ELEMENT, ObjectAssert<ELEMENT>>> {
  I testInput();

  I emptyInput();

  A assertion(I testInput);

  ELEMENT expectedFirstElement();

  ELEMENT unexpectedFirstElement();

  @Test
  default void passes() {
    assertion(testInput()).first().isEqualTo(expectedFirstElement());
  }

  @Test
  default void passesWithAssertFactory() {
    assertion(testInput()).first(InstanceOfAssertFactories.STRING).endsWith(expectedFirstElement().toString());
  }

  @Test
  default void failsElementAssertion() {
    assertion(testInput()).first().isEqualTo(unexpectedFirstElement());
  }

  @Test
  default void failsElementAssertionUsingAssertFactory() {
    assertion(testInput()).first(InstanceOfAssertFactories.STRING).endsWith(unexpectedFirstElement().toString());
  }

  @Test
  default void failsWithEmptyInput() {
    assertion(emptyInput()).first().isEqualTo(expectedFirstElement());
  }
}
