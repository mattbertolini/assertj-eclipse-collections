package org.assertj.eclipse.collections.api;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;
import org.eclipse.collections.api.RichIterable;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public interface AbstractRichIterableAssert_IsEmpty_Contract<ELEMENT, I extends RichIterable<ELEMENT>, A extends AbstractRichIterableAssert<A, I, ELEMENT, ObjectAssert<ELEMENT>>> {
  I testInput();

  I emptyInput();

  A assertion(I testInput);

  @Test
  default void passes() {
    assertion(emptyInput()).isEmpty();
  }

  @Test
  default void fails() {
    assertion(testInput()).isEmpty();
  }

  @Test
  default void failsNullInput() {
    assertThatExceptionOfType(AssertionError.class)
      .isThrownBy(() -> assertion(null).isEmpty())
      .withMessageContaining("Expecting actual not to be null");
  }
}
