package org.assertj.eclipse.collections.api.ordered;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.api.ObjectAssert;
import org.eclipse.collections.api.ordered.OrderedIterable;
import org.junit.jupiter.api.Test;

public interface AbstractOrderedIterableAssert_Last_Contract<ELEMENT, I extends OrderedIterable<ELEMENT>, A extends AbstractOrderedIterableAssert<A, I, ELEMENT, ObjectAssert<ELEMENT>>> {
  I testInput();

  A assertion(I testInput);

  ELEMENT expectedLastElement();

  ELEMENT unexpectedLastElement();

  @Test
  default void passes() {
    assertion(testInput()).last().isEqualTo(expectedLastElement());
  }

  @Test
  default void passesWithAssertFactory() {
    assertion(testInput()).last(InstanceOfAssertFactories.STRING).endsWith(expectedLastElement().toString());
  }

  @Test
  default void fails() {
    assertion(testInput()).last().isEqualTo(unexpectedLastElement());
  }

  @Test
  default void failsWithAssertFactory() {
    assertion(testInput()).last(InstanceOfAssertFactories.STRING).endsWith(unexpectedLastElement().toString());
  }
}
