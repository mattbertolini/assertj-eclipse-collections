package org.assertj.eclipse.collections.api.list;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.InstanceOfAssertFactory;
import org.assertj.core.util.CheckReturnValue;
import org.assertj.eclipse.collections.api.ordered.AbstractReversibleIterableAssert;
import org.eclipse.collections.api.list.ListIterable;

public abstract class AbstractListIterableAssert<SELF extends AbstractListIterableAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT>,
  ACTUAL extends ListIterable<? extends ELEMENT>,
  ELEMENT,
  ELEMENT_ASSERT extends AbstractAssert<ELEMENT_ASSERT, ELEMENT>>
  extends AbstractReversibleIterableAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT> {

  protected AbstractListIterableAssert(ACTUAL elements, Class<?> selfType) {
    super(elements, selfType);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @CheckReturnValue
  public ELEMENT_ASSERT element(int index) {
    return internalElement(index);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @CheckReturnValue
  public <ASSERT extends AbstractAssert<?, ?>> ASSERT element(int index, InstanceOfAssertFactory<?, ASSERT> assertFactory) {
    return internalElement(index).asInstanceOf(assertFactory);
  }

  private ELEMENT_ASSERT internalElement(int index) {
    isNotEmpty();
    assertThat(index).describedAs(navigationDescription("check index validity"))
      .isBetween(0, actual.size() - 1);
    return toAssert(actual.get(index), navigationDescription("element at index " + index));
  }
}
