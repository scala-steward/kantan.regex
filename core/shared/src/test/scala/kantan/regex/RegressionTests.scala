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

package kantan.regex

import org.scalatest.funsuite.AnyFunSuite

class RegressionTests extends AnyFunSuite {
  // - Node & Match Decoder instances for non default types ------------------------------------------------------------
  // -------------------------------------------------------------------------------------------------------------------
  class A
  class B

  implicit val groupDecoderA: GroupDecoder[A] = GroupDecoder.from(_ => DecodeResult.success(new A))
  implicit val groupDecoderB: GroupDecoder[B] = GroupDecoder.from(_ => DecodeResult.success(new B))

  test("Option decoders should be available for types that do not have a StringDecoder") {
    GroupDecoder[Option[A]]
    MatchDecoder[Option[A]]
    ()
  }

  test("Either decoders should be available for types that do not have a StringDecoder") {
    GroupDecoder[Either[A, B]]
    MatchDecoder[Either[A, B]]
    ()
  }
}
