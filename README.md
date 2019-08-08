# assertt

[![Jitpack](https://jitpack.io/v/toss/assertt.svg)](https://jitpack.io/#toss/assertt)
[![Build Status](https://travis-ci.org/toss/assertt.svg?branch=master)](https://travis-ci.org/toss/assertt)
[![codecov](https://codecov.io/gh/toss/assertt/branch/master/graph/badge.svg)](https://codecov.io/gh/toss/assertt)

Assertions for Kotlin

## Usage

[Add the dependency](https://jitpack.io/#toss/assertt/v0.1.0) and
follow the below examples.

```kotlin
// assertj
assertThat(1).isEqualTo(1)

// junit
assertEquals(1, 1)

// assertt
1.equalsTo(1)
```

See the [tests](./src/test/kotlin/im/toss/assertt/AssertionsKtTest.kt) for more examples.

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
