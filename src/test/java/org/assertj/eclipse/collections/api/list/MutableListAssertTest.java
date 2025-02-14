package org.assertj.eclipse.collections.api.list;

import org.assertj.eclipse.collections.api.AbstractRichIterableAssert_HasSize_Contract;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.junit.jupiter.api.Nested;

class MutableListAssertTest {

  protected MutableList<String> testInput() {
    return Lists.mutable.of("TOS", "TNG", "DS9", "VOY", "ENT");
  }

  @Nested
  class HasSize implements AbstractRichIterableAssert_HasSize_Contract<String, MutableList<String>, MutableListAssert<String>> {

    @Override
    public MutableList<String> testInput() {
      return MutableListAssertTest.this.testInput();
    }

    @Override
    public MutableListAssert<String> assertion(MutableList<String> testInput) {
      return MutableListAssert.assertThat(testInput);
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
}
