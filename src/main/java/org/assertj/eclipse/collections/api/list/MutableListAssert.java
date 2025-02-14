package org.assertj.eclipse.collections.api.list;

import java.util.List;

import org.assertj.core.api.ObjectAssert;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;

/**
 * Assertion methods for {@link MutableList}s.
 * <p>
 * To create an instance of this class, invoke <code>{@link Assertions#assertThat(List)}</code>.
 * <p>
 *
 * @param <ELEMENT> the type of elements of the "actual" value.
 */
public class MutableListAssert<ELEMENT> extends AbstractListIterableAssert<MutableListAssert<ELEMENT>, MutableList<ELEMENT>, ELEMENT, ObjectAssert<ELEMENT>> {

  public static <ELEMENT> MutableListAssert<ELEMENT> assertThat(MutableList<ELEMENT> actual) {
    return new MutableListAssert<>(actual);
  }

  /**
   * Constructs a new {@code MutableListAssert} instance for performing assertions on a {@link MutableList}.
   *
   * @param actual the {@code MutableList} on which assertions are to be performed
   */
  public MutableListAssert(MutableList<ELEMENT> actual) {
    super(actual, MutableListAssert.class);
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
  protected MutableListAssert<ELEMENT> newAbstractIterableAssert(Iterable<? extends ELEMENT> iterable) {
    return new MutableListAssert<>(Lists.mutable.ofAll(iterable));
  }
}
