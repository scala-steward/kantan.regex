/*
 * Copyright 2016 Nicolas Rinaudo
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

package kantan.regex.laws

import kantan.codecs.laws.discipline.DecoderTests
import kantan.regex._

package object discipline {
  type GroupDecoderTests[A] = DecoderTests[String, A, DecodeError, codecs.type]
  type MatchDecoderTests[A] = DecoderTests[Match, A, DecodeError, codecs.type]
}
