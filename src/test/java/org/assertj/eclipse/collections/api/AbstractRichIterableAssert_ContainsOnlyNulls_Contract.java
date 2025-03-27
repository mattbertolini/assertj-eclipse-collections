package org.assertj.eclipse.collections.api;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.api.ObjectAssert;
import org.eclipse.collections.api.RichIterable;
import org.junit.jupiter.api.Test;

public interface AbstractRichIterableAssert_ContainsOnlyNulls_Contract<ELEMENT, I extends RichIterable<ELEMENT>, A extends AbstractRichIterableAssert<A, I, ELEMENT, ObjectAssert<ELEMENT>>> {
  I testInput();

  I inputWithNonNullElements();

  I emptyInput();

  A assertion(I testInput);

  @Test
  default void passes() {
    assertion(testInput()).containsOnlyNulls();
  }

  @Test
  default void failsWithNonNullElements() {
    assertion(inputWithNonNullElements()).containsOnlyNulls();
  }

  @Test
  default void failsWithEmptyInput() {
    assertion(emptyInput()).containsOnlyNulls();
  }

  @Test
  default void failsWithNullInput() {
    assertThatExceptionOfType(AssertionError.class)
      .isThrownBy(() -> assertion(null).containsOnlyNulls())
      .withMessageContaining("Expecting actual not to be null");
  }
}
