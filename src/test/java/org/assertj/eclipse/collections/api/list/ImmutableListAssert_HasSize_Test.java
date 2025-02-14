package org.assertj.eclipse.collections.api.list;

import org.assertj.eclipse.collections.api.AbstractRichIterableAssert_HasSize_Contract;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;

public class ImmutableListAssert_HasSize_Test implements AbstractRichIterableAssert_HasSize_Contract<String, ImmutableList<String>, ImmutableListAssert<String>> {
  @Override
  public ImmutableList<String> testInput() {
    return Lists.immutable.of("TOS", "TNG", "DS9", "VOY", "ENT");
  }

  @Override
  public ImmutableListAssert<String> assertion(ImmutableList<String> testInput) {
    return ImmutableListAssert.assertThat(testInput);
  }

  @Override
  public int expectedSize() {
    return 5;
  }

  @Override
  public int unexpectedSize() {
    return 3;
  }
}
