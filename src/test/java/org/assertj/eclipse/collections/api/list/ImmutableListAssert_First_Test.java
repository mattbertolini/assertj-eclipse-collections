package org.assertj.eclipse.collections.api.list;

import org.assertj.eclipse.collections.api.ordered.AbstractOrderedIterableAssert_First_Contract;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;

class ImmutableListAssert_First_Test implements AbstractOrderedIterableAssert_First_Contract<String, ImmutableList<String>, ImmutableListAssert<String>> {
  @Override
  public ImmutableList<String> testInput() {
    return Lists.immutable.of("TOS", "TNG", "DS9", "VOY", "ENT");
  }

  @Override
  public ImmutableList<String> emptyInput() {
    return Lists.immutable.empty();
  }

  @Override
  public String expectedFirstElement() {
    return "TOS";
  }

  @Override
  public String unexpectedFirstElement() {
    return "VOY";
  }

  @Override
  public ImmutableListAssert<String> assertion(ImmutableList<String> testInput) {
    return ImmutableListAssert.assertThat(testInput);
  }
}
