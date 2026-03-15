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
package org.assertj.eclipse.collections.test.api.multimap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.assertj.eclipse.collections.api.multimap.MultimapAssert;
import org.eclipse.collections.api.multimap.Multimap;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MultimapAssert_AnySatisfy_Test {
  @ParameterizedTest
  @MethodSource("org.assertj.eclipse.collections.test.api.multimap.MultimapTestData#nonEmptyMultimaps")
  void passes(Multimap<String, String> actual) {
    assertThatNoException().isThrownBy(() -> new MultimapAssert<>(actual).anySatisfy((key, value) -> {
      assertThat(key).isEqualTo("TNG");
      assertThat(value).isEqualTo("Picard");
    }));
  }

  @ParameterizedTest
  @MethodSource("org.assertj.eclipse.collections.test.api.multimap.MultimapTestData#nonEmptyMultimaps")
  void failsNoSatisfies(Multimap<String, String> actual) {
    assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> new MultimapAssert<>(actual).anySatisfy((key, value) -> {
      assertThat(key).isEqualTo("XYZ");
      assertThat(value).isEqualTo("Not Found");
    })).withMessageContaining("Expecting any element of")
      .withMessageContaining("to satisfy the given assertions requirements but none did");
  }
}
