package org.assertj.eclipse.collections.api;

import org.assertj.core.api.ObjectAssert;
import org.eclipse.collections.api.RichIterable;
import org.junit.jupiter.api.Test;

public interface AbstractRichIterableAssert_HasSize_Contract<ELEMENT, I extends RichIterable<ELEMENT>, A extends AbstractRichIterableAssert<A, I, ELEMENT, ObjectAssert<ELEMENT>>> {
  I testInput();

  A assertion(I testInput);

  int expectedSize();

  int unexpectedSize();

  @Test
  default void passes() {
    assertion(testInput()).hasSize(expectedSize());
  }

  @Test
  default void fails() {
    assertion(testInput()).hasSize(unexpectedSize());
  }
}
