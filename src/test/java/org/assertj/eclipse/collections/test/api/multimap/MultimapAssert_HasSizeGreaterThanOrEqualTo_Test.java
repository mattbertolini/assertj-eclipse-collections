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

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.assertj.eclipse.collections.api.SoftAssertions;
import org.assertj.eclipse.collections.api.multimap.MultimapAssert;
import org.eclipse.collections.api.multimap.Multimap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MultimapAssert_HasSizeGreaterThanOrEqualTo_Test {
  @ParameterizedTest
  @MethodSource("org.assertj.eclipse.collections.test.api.multimap.MultimapTestData#sizeLowerBoundaryTestData")
  void passesGreaterThan(Multimap<String, String> actual, int lowerBoundary) {
    assertThatNoException().isThrownBy(() -> new MultimapAssert<>(actual).hasSizeGreaterThanOrEqualTo(lowerBoundary));
  }

  @ParameterizedTest
  @MethodSource("org.assertj.eclipse.collections.test.api.multimap.MultimapTestData#sizeUpperBoundaryTestData")
  void failsLesser(Multimap<String, String> actual, int upperBoundary) {
    assertThatExceptionOfType(AssertionError.class)
      .isThrownBy(() -> new MultimapAssert<>(actual).hasSizeGreaterThanOrEqualTo(upperBoundary))
      .withMessageContaining("Expecting size of")
      .withMessageContaining(String.format("to be greater than or equal to %s but was %s", upperBoundary, actual.size()));
  }

  @ParameterizedTest
  @MethodSource("org.assertj.eclipse.collections.test.api.multimap.MultimapTestData#sizeEqualsTestData")
  void passesEquals(Multimap<String, String> actual, int equalsBoundary) {
    assertThatNoException().isThrownBy(() -> new MultimapAssert<>(actual).hasSizeGreaterThanOrEqualTo(equalsBoundary));
  }

  @Test
  void failsNullMultimap() {
    int lowerBoundary = 2; // Using the same value as in SizeLowerBoundaryTestData
    assertThatExceptionOfType(AssertionError.class)
      .isThrownBy(() -> new MultimapAssert<>(null).hasSizeGreaterThanOrEqualTo(lowerBoundary))
      .withMessageContaining("Expecting actual not to be null");
  }

  @ParameterizedTest
  @MethodSource("org.assertj.eclipse.collections.test.api.multimap.MultimapTestData#emptyMultimaps")
  void failsEmptyMultimap(Multimap<String, String> actual) {
    int lowerBoundary = 2; // Using the same value as in SizeLowerBoundaryTestData
    assertThatExceptionOfType(AssertionError.class)
      .isThrownBy(() -> new MultimapAssert<>(actual).hasSizeGreaterThanOrEqualTo(lowerBoundary))
      .withMessageContaining(String.format("to be greater than or equal to %s but was 0", lowerBoundary));
  }

  @ParameterizedTest
  @MethodSource("org.assertj.eclipse.collections.test.api.multimap.MultimapTestData#sizeLowerBoundaryTestData")
  void softAssertionPasses(Multimap<String, String> actual, int lowerBoundary) {
    SoftAssertions.assertSoftly(softly -> softly.assertThat(actual).hasSizeGreaterThanOrEqualTo(lowerBoundary));
  }
}
