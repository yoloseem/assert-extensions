# assert-extensions

[![Jitpack](https://jitpack.io/v/toss/assert-extensions.svg)](https://jitpack.io/#toss/assert-extensions)
[![Build Status](https://travis-ci.org/toss/assert-extensions.svg?branch=master)](https://travis-ci.org/toss/assert-extensions)
[![codecov](https://codecov.io/gh/toss/assert-extensions/branch/master/graph/badge.svg)](https://codecov.io/gh/toss/assert-extensions)

Assertions for Kotlin

## Usage

[Add the dependency](https://jitpack.io/#toss/assert-extensions) and
follow the below examples.

```kotlin
// assertj
assertThat(actual).isEqualTo(expected)

// junit
assertEquals(expected, actual)

// assert-extensions
actual equalsTo expected
```

See the [tests](./src/test/kotlin/im/toss/assert-extensions/AssertionsKtTest.kt) for more examples.

## Maintainers

* [Yi EungJun](https://github.com/eungjun-yi)

## License

    Copyright 2019 Viva Republica, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
