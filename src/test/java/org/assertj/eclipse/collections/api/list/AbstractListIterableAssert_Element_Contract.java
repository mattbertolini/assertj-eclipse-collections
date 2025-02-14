package org.assertj.eclipse.collections.api.list;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.api.ObjectAssert;
import org.eclipse.collections.api.list.ListIterable;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public interface AbstractListIterableAssert_Element_Contract<ELEMENT, I extends ListIterable<ELEMENT>, A extends AbstractListIterableAssert<A, I, ELEMENT, ObjectAssert<ELEMENT>>> {
  I testInput();

  A assertion(I testInput);

  ElementData<ELEMENT> expectedElement();

  ElementData<ELEMENT> unexpectedElement();

  @Test
  default void passes() {
    assertion(testInput()).element(expectedElement().index()).isEqualTo(expectedElement().value());
  }

  @Test
  default void passesWithAssertFactory() {
    assertion(testInput()).element(expectedElement().index(), InstanceOfAssertFactories.STRING).endsWith(expectedElement().value().toString());
  }

  @Test
  default void fails() {
    assertion(testInput()).element(unexpectedElement().index()).isEqualTo(unexpectedElement().value());
  }

  @Test
  default void failsWithAssertFactory() {
    assertion(testInput()).element(unexpectedElement().index(), InstanceOfAssertFactories.STRING).endsWith(unexpectedElement().value().toString());
  }

  final class ElementData<ELEMENT> {
    private final int index;
    private final ELEMENT value;

    public ElementData(int index, ELEMENT value) {
      this.index = index;
      this.value = value;
    }

    public int index() {
      return index;
    }

    public ELEMENT value() {
      return value;
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof AbstractListIterableAssert_Element_Contract.ElementData)) return false;
      ElementData<?> elementData = (ElementData<?>) o;
      return index == elementData.index && Objects.equals(value, elementData.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(index, value);
    }
  }
}
