package org.assertj.eclipse.collections.api.list;

import org.assertj.eclipse.collections.api.AbstractRichIterableAssert_IsNotEmpty_Contract;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;

public class ImmutableListAssert_IsNotEmpty_Test implements AbstractRichIterableAssert_IsNotEmpty_Contract<String, ImmutableList<String>, ImmutableListAssert<String>> {
  @Override
  public ImmutableList<String> testInput() {
    return Lists.immutable.of("TOS", "TNG", "DS9", "VOY", "ENT");
  }

  @Override
  public ImmutableList<String> emptyInput() {
    return Lists.immutable.empty();
  }

  @Override
  public ImmutableListAssert<String> assertion(ImmutableList<String> testInput) {
    return ImmutableListAssert.assertThat(testInput);
  }
}
