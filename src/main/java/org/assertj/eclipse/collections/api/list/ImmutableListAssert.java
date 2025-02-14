package org.assertj.eclipse.collections.api.list;

import org.assertj.core.api.ObjectAssert;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;

import java.util.List;

/**
 * Assertion methods for {@link ImmutableList}s.
 * <p>
 * To create an instance of this class, invoke <code>{@link Assertions#assertThat(List)}</code>.
 * <p>
 *
 * @param <ELEMENT> the type of elements of the "actual" value.
 */
public class ImmutableListAssert<ELEMENT> extends AbstractListIterableAssert<ImmutableListAssert<ELEMENT>, ImmutableList<ELEMENT>, ELEMENT, ObjectAssert<ELEMENT>> {

  public static <ELEMENT> ImmutableListAssert<ELEMENT> assertThat(ImmutableList<ELEMENT> actual) {
    return new ImmutableListAssert<>(actual);
  }

  /**
   * Constructs a new {@code ImmutableListAssert} instance for performing assertions on an {@code ImmutableList}.
   *
   * @param actual the {@code ImmutableList} on which assertions are to be performed
   */
  public ImmutableListAssert(ImmutableList<ELEMENT> actual) {
    super(actual, ImmutableListAssert.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected ObjectAssert<ELEMENT> toAssert(ELEMENT value, String description) {
    return new ObjectAssert<>(value).as(description);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected ImmutableListAssert<ELEMENT> newAbstractIterableAssert(Iterable<? extends ELEMENT> iterable) {
    return new ImmutableListAssert<>(Lists.immutable.ofAll(iterable));
  }
}
