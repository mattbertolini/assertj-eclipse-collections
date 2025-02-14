package org.assertj.eclipse.collections.api;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.api.ObjectAssert;
import org.assertj.eclipse.collections.api.ordered.AbstractOrderedIterableAssert;
import org.eclipse.collections.api.ordered.OrderedIterable;
import org.junit.jupiter.api.Test;

public interface AbstractRichIterableAssert_SingleElement_Contract<ELEMENT, I extends OrderedIterable<ELEMENT>, A extends AbstractOrderedIterableAssert<A, I, ELEMENT, ObjectAssert<ELEMENT>>> {
  I testInput();

  I largeInput();

  A assertion(I testInput);

  ELEMENT expectedElement();

  ELEMENT unexpectedElement();

  @Test
  default void passes() {
    assertion(testInput()).singleElement().isEqualTo(expectedElement());
  }

  @Test
  default void passesWithAssertFactory() {
    assertion(testInput()).singleElement(InstanceOfAssertFactories.STRING).endsWith(expectedElement().toString());
  }

  @Test
  default void fails() {
    assertion(testInput()).singleElement().isEqualTo(unexpectedElement());
  }

  @Test
  default void failsWithAssertFactory() {
    assertion(testInput()).singleElement(InstanceOfAssertFactories.STRING).endsWith(unexpectedElement().toString());
  }

  @Test
  default void failsOrderedIterableIsLargerThanSingleElement() {
    assertion(largeInput()).singleElement().isEqualTo(expectedElement());
  }
}
