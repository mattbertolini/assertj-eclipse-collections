package org.assertj.eclipse.collections.api;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AbstractIterableAssert;
import org.eclipse.collections.api.InternalIterable;

public abstract class AbstractInternalIterableAssert<SELF extends AbstractInternalIterableAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT>,
  ACTUAL extends InternalIterable<? extends ELEMENT>,
  ELEMENT,
  ELEMENT_ASSERT extends AbstractAssert<ELEMENT_ASSERT, ELEMENT>>
  extends AbstractIterableAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT> {

  protected AbstractInternalIterableAssert(ACTUAL actual, Class<?> selfType) {
    super(actual, selfType);
  }
}
