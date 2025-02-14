package org.assertj.eclipse.collections.api;

import org.assertj.core.api.ObjectAssert;
import org.eclipse.collections.api.RichIterable;
import org.junit.jupiter.api.Test;

public interface AbstractRichIterableAssert_IsNotEmpty_Contract<ELEMENT, I extends RichIterable<ELEMENT>, A extends AbstractRichIterableAssert<A, I, ELEMENT, ObjectAssert<ELEMENT>>> {
  I testInput();

  I emptyInput();

  A assertion(I testInput);

  @Test
  default void passes() {
    assertion(testInput()).isNotEmpty();
  }

  @Test
  default void fails() {
    assertion(emptyInput()).isNotEmpty();
  }

  @Test
  default void failsNullInput() {
    assertion(null).isNotEmpty();
  }
}
