package org.assertj.eclipse.collections.api.list;

import org.assertj.eclipse.collections.api.AbstractRichIterableAssert_SingleElement_Contract;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;

public class ImmutableListAssert_SingleElement_Test implements AbstractRichIterableAssert_SingleElement_Contract<String, ImmutableList<String>, ImmutableListAssert<String>> {
  @Override
  public ImmutableList<String> testInput() {
    return Lists.immutable.of("TNG");
  }

  @Override
  public ImmutableList<String> largeInput() {
    return Lists.immutable.of("TOS", "TNG", "DS9", "VOY", "ENT");
  }

  @Override
  public ImmutableListAssert<String> assertion(ImmutableList<String> testInput) {
    return ImmutableListAssert.assertThat(testInput);
  }

  @Override
  public String expectedElement() {
    return "TNG";
  }

  @Override
  public String unexpectedElement() {
    return "VOY";
  }
}
