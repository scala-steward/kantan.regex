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
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

@SuppressWarnings(Array("org.wartremover.warts.Throw"))
class DecodeResultTests extends AnyFunSuite with ScalaCheckPropertyChecks with Matchers {
  test("DecodeResult.success should return a success") {
    forAll { i: Int =>
      DecodeResult.success(i) should be(Right(i))
    }
  }

  test("DecodeResult.apply should return a success on 'good' values") {
    forAll { i: Int =>
      DecodeResult(i) should be(Right(i))
    }
  }

  test("DecodeResult.apply should return a failure on 'bad' values") {
    forAll { e: Exception =>
      DecodeResult(throw e) should be(Left(DecodeError.TypeError(e)))
    }
  }

  test("DecodeResult.typeError should return a failure") {
    forAll { e: Exception =>
      DecodeResult.typeError(e) should be(Left(DecodeError.TypeError(e)))

      DecodeResult.typeError(e.getMessage) match {
        case Left(DecodeError.TypeError(m)) => m should be(e.getMessage)
        case a                              => fail(s"$a was not a type error")
      }
    }
  }

  test("DecodeResult.noSuchGroupId should return a failure ") {
    forAll { i: Int =>
      DecodeResult.noSuchGroupId(i) should be(Left(DecodeError.NoSuchGroupId(i)))
    }
  }
}