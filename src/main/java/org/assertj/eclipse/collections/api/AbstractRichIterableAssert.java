/*
 * Copyright 2025-2026 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.assertj.eclipse.collections.api;

import static org.assertj.core.error.ShouldHaveSize.shouldHaveSize;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AbstractIterableAssert;
import org.eclipse.collections.api.RichIterable;

/**
 * Base class for implementations of Eclipse Collections {@link RichIterable} assertions.
 *
 * @param <SELF>           the "self" type of this assertion class. Please read &quot;<a href="https://bit.ly/1IZIRcY"
 *                         target="_blank">Emulating 'self types' using Java Generics to simplify fluent API implementation</a>&quot;
 *                         for more details.
 * @param <ACTUAL>         the type of the "actual" value.
 * @param <ELEMENT>        the type of elements of the "actual" value.
 * @param <ELEMENT_ASSERT> used for navigational assertions to return the right assert type.
 */
//@format:off
public abstract class AbstractRichIterableAssert<SELF extends AbstractRichIterableAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT>,
  ACTUAL extends RichIterable<? extends ELEMENT>,
  ELEMENT,
  ELEMENT_ASSERT extends AbstractAssert<? extends ELEMENT_ASSERT, ELEMENT>>
  extends AbstractIterableAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT> {
//@format:on

  protected AbstractRichIterableAssert(ACTUAL actual, Class<?> selfType) {
    super(actual, selfType);
  }

  /**
   * Verifies that the number of values in the actual RichIterable is equal to the given one.
   * <p>
   * Example:
   * <pre>{@code
   * // assertions will pass
   * assertThat(Sets.immutable.of("TNG", "DS9")).hasSize(2);
   * assertThat(Bags.immutable.of(1, 2, 3)).hasSize(3);
   *
   * // assertions will fail
   * assertThat(Sets.immutable.empty()).hasSize(1);
   * assertThat(Bags.immutable.of(1, 2, 3)).hasSize(2);
   * }</pre>
   *
   * @param expected the expected number of values in the actual collection.
   * @return {@code this} assertion object.
   * @throws AssertionError if the number of values of the actual collection is not equal to the given one.
   */
  @Override
  public SELF hasSize(int expected) {
    isNotNull();

    int actualSize = actual.size();
    if (actualSize == expected) {
      return myself;
    }

    throw assertionError(shouldHaveSize(actual, actualSize, expected));
  }
}
