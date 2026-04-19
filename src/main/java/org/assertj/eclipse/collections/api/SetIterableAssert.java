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
package org.assertj.eclipse.collections.api;

import org.assertj.core.api.ObjectAssert;
import org.eclipse.collections.api.factory.Sets;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.SetIterable;

public class SetIterableAssert<ELEMENT> extends AbstractRichIterableAssert<SetIterableAssert<ELEMENT>, SetIterable<? extends ELEMENT>, ELEMENT, ObjectAssert<ELEMENT>> {
  public SetIterableAssert(SetIterable<? extends ELEMENT> elements) {
    super(elements, SetIterableAssert.class);
  }

  @Override
  protected ObjectAssert<ELEMENT> toAssert(ELEMENT value) {
    return new ObjectAssert<>(value);
  }

  @Override
  protected SetIterableAssert<ELEMENT> newAbstractIterableAssert(Iterable<? extends ELEMENT> iterable) {
    ImmutableSet<? extends ELEMENT> elements = Sets.immutable.ofAll(iterable);
    return new SetIterableAssert<>(elements);
  }
}
