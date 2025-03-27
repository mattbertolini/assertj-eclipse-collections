package org.assertj.eclipse.collections.api.list;

import org.assertj.eclipse.collections.api.AbstractRichIterableAssert_ContainsOnlyNulls_Contract;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;

class ImmutableListAssert_ContainsOnlyNulls_Test implements AbstractRichIterableAssert_ContainsOnlyNulls_Contract<String, ImmutableList<String>, ImmutableListAssert<String>> {
  @Override
  public ImmutableList<String> testInput() {
    return Lists.immutable.of(null, null, null);
  }

  @Override
  public ImmutableList<String> inputWithNonNullElements() {
    return Lists.immutable.of(null, "non-null", null);
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
