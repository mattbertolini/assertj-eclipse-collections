package org.assertj.eclipse.collections.api.ordered;

import org.assertj.core.api.AbstractAssert;
import org.eclipse.collections.api.ordered.ReversibleIterable;

public abstract class AbstractReversibleIterableAssert<SELF extends AbstractReversibleIterableAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT>,
  ACTUAL extends ReversibleIterable<? extends ELEMENT>,
  ELEMENT,
  ELEMENT_ASSERT extends AbstractAssert<ELEMENT_ASSERT, ELEMENT>>
  extends AbstractOrderedIterableAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT> {

  protected AbstractReversibleIterableAssert(ACTUAL elements, Class<?> selfType) {
    super(elements, selfType);
  }
}
