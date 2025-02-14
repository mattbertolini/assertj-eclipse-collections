package org.assertj.eclipse.collections.api;

import static org.assertj.core.error.ShouldHaveSize.shouldHaveSize;
import static org.assertj.core.error.ShouldNotBeEmpty.shouldNotBeEmpty;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.InstanceOfAssertFactory;
import org.assertj.core.util.CheckReturnValue;
import org.eclipse.collections.api.RichIterable;

public abstract class AbstractRichIterableAssert<SELF extends AbstractRichIterableAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT>,
  ACTUAL extends RichIterable<? extends ELEMENT>,
  ELEMENT,
  ELEMENT_ASSERT extends AbstractAssert<ELEMENT_ASSERT, ELEMENT>>
  extends AbstractInternalIterableAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT> {

  protected AbstractRichIterableAssert(ACTUAL actual, Class<?> selfType) {
    super(actual, selfType);
  }

  /**
   * {@inheritDoc}
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

  /**
   * {@inheritDoc}
   */
  @Override
  public SELF isNotEmpty() {
    isNotNull();
    if (actual.notEmpty()) {
      return myself;
    }
    throw assertionError(shouldNotBeEmpty());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @CheckReturnValue
  public ELEMENT_ASSERT singleElement() {
    return internalSingleElement();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @CheckReturnValue
  public <ASSERT extends AbstractAssert<?, ?>> ASSERT singleElement(InstanceOfAssertFactory<?, ASSERT> assertFactory) {
    return internalSingleElement().asInstanceOf(assertFactory);
  }

  private ELEMENT_ASSERT internalSingleElement() {
    hasSize(1);
    return toAssert(actual.getOnly(), navigationDescription("check single element"));
  }
}
