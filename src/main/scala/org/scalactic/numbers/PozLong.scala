/*
 * Copyright 2001-2014 Artima, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.scalactic.numbers

//
// Numbers greater than or equal to zero.
//
// (Pronounced like "posey".)
//

final class PozLong private (val value: Long) extends AnyVal with RestrictedLong {
  override def toString: String = s"PozLong($value)"
}

object PozLong {
  def from(value: Long): Option[PozLong] =
    if (value >= 0L) Some(new PozLong(value)) else None
  import language.experimental.macros
  import scala.language.implicitConversions
  implicit def apply(value: Long): PozLong = macro PozLongMacro.apply
}
