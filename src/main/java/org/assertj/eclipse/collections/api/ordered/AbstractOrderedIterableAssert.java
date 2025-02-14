package org.assertj.eclipse.collections.api.ordered;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.InstanceOfAssertFactory;
import org.assertj.core.util.CheckReturnValue;
import org.assertj.eclipse.collections.api.AbstractRichIterableAssert;
import org.eclipse.collections.api.ordered.OrderedIterable;

public abstract class AbstractOrderedIterableAssert<SELF extends AbstractOrderedIterableAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT>,
  ACTUAL extends OrderedIterable<? extends ELEMENT>,
  ELEMENT,
  ELEMENT_ASSERT extends AbstractAssert<ELEMENT_ASSERT, ELEMENT>>
  extends AbstractRichIterableAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT> {

  protected AbstractOrderedIterableAssert(ACTUAL elements, Class<?> selfType) {
    super(elements, selfType);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @CheckReturnValue
  public ELEMENT_ASSERT first() {
    return internalFirst();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @CheckReturnValue
  public <ASSERT extends AbstractAssert<?, ?>> ASSERT first(InstanceOfAssertFactory<?, ASSERT> assertFactory) {
    return internalFirst().asInstanceOf(assertFactory);
  }

  private ELEMENT_ASSERT internalFirst() {
    isNotEmpty();
    return toAssert(actual.getFirst(), navigationDescription("check first element"));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @CheckReturnValue
  public ELEMENT_ASSERT last() {
    return internalLast();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @CheckReturnValue
  public <ASSERT extends AbstractAssert<?, ?>> ASSERT last(InstanceOfAssertFactory<?, ASSERT> assertFactory) {
    return internalLast().asInstanceOf(assertFactory);
  }

  private ELEMENT_ASSERT internalLast() {
    isNotEmpty();
    return toAssert(actual.getLast(), navigationDescription("check last element"));
  }
}
