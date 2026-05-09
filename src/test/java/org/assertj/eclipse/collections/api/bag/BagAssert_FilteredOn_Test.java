/*
 * Copyright 2025-2026 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.assertj.eclipse.collections.api.bag;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.function.Function;
import java.util.function.Predicate;

import org.assertj.eclipse.collections.api.BagAssert;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.factory.Bags;
import org.junit.jupiter.api.Test;

public class BagAssert_FilteredOn_Test {
  @Test
  void filteredOn_function_passes() {
    ImmutableBag<String> bag = Bags.immutable.of("TOS", "TNG", "DS9", "VOY", "ENT");

    assertThatNoException().isThrownBy(() -> new BagAssert<>(bag).filteredOn(s -> s.charAt(0), 'T')
      .hasSize(2)
      .containsOnly("TOS", "TNG"));
  }

  @Test
  void filteredOn_function_nullFunction_throwsException() {
    ImmutableBag<String> bag = Bags.immutable.of("TOS", "TNG", "DS9", "VOY", "ENT");

    assertThatExceptionOfType(IllegalArgumentException.class)
      .isThrownBy(() -> new BagAssert<>(bag).filteredOn((Function) null, 'T'))
      .withMessageContaining("The filter function should not be null");
  }

  @Test
  void filteredOn_predicate_passes() {
    ImmutableBag<String> bag = Bags.immutable.of("TOS", "TNG", "DS9", "VOY", "ENT");

    assertThatNoException().isThrownBy(() -> new BagAssert<>(bag).filteredOn(s -> s.startsWith("T"))
      .hasSize(2)
      .containsOnly("TOS", "TNG"));
  }

  @Test
  void filteredOn_predicate_nullPredicate_throwsException() {
    ImmutableBag<String> bag = Bags.immutable.of("TOS", "TNG", "DS9", "VOY", "ENT");

    assertThatExceptionOfType(IllegalArgumentException.class)
      .isThrownBy(() -> new BagAssert<>(bag).filteredOn((Predicate) null))
      .withMessageContaining("The filter predicate should not be null");
  }
}
