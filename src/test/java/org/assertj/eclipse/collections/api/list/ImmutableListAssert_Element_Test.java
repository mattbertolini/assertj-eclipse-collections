package org.assertj.eclipse.collections.api.list;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;

class ImmutableListAssert_Element_Test implements AbstractListIterableAssert_Element_Contract<String, ImmutableList<String>, ImmutableListAssert<String>> {
  @Override
  public ImmutableList<String> testInput() {
    return Lists.immutable.of("TOS", "TNG", "DS9", "VOY", "ENT");
  }

  @Override
  public ImmutableListAssert<String> assertion(ImmutableList<String> testInput) {
    return ImmutableListAssert.assertThat(testInput);
  }

  @Override
  public ElementData<String> expectedElement() {
    return new ElementData<>(2, "DS9");
  }

  @Override
  public ElementData<String> unexpectedElement() {
    return new ElementData<>(1, "VOY");
  }
}
