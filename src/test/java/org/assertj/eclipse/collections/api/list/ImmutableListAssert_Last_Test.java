package org.assertj.eclipse.collections.api.list;

import org.assertj.eclipse.collections.api.ordered.AbstractOrderedIterableAssert_Last_Contract;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;

class ImmutableListAssert_Last_Test implements AbstractOrderedIterableAssert_Last_Contract<String, ImmutableList<String>, ImmutableListAssert<String>> {
  @Override
  public ImmutableList<String> testInput() {
    return Lists.immutable.of("TOS", "TNG", "DS9", "VOY", "ENT");
  }

  @Override
  public String expectedLastElement() {
    return "ENT";
  }

  @Override
  public String unexpectedLastElement() {
    return "VOY";
  }

  @Override
  public ImmutableListAssert<String> assertion(ImmutableList<String> testInput) {
    return ImmutableListAssert.assertThat(testInput);
  }
}
