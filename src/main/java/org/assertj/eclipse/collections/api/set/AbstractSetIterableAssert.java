package org.assertj.eclipse.collections.api.set;

import org.assertj.core.api.AbstractAssert;
import org.assertj.eclipse.collections.api.AbstractRichIterableAssert;
import org.eclipse.collections.api.set.SetIterable;

public abstract class AbstractSetIterableAssert<SELF extends AbstractSetIterableAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT>,
  ACTUAL extends SetIterable<? extends ELEMENT>,
  ELEMENT,
  ELEMENT_ASSERT extends AbstractAssert<ELEMENT_ASSERT, ELEMENT>>
  extends AbstractRichIterableAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT> {

  protected AbstractSetIterableAssert(ACTUAL actual, Class<?> selfType) {
    super(actual, selfType);
  }
}
