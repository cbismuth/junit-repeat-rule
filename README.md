# JUnit repeat rule

[![build](https://travis-ci.org/cbismuth/junit-repeat-rule.svg?branch=master)](https://travis-ci.org/cbismuth/junit-repeat-rule)
[![coverage](https://coveralls.io/repos/github/cbismuth/junit-repeat-rule/badge.svg?branch=master)](https://coveralls.io/github/cbismuth/junit-repeat-rule?branch=master)
[![javadoc](http://javadoc.io/badge/com.github.cbismuth/junit-repeat-rule.svg)](http://javadoc.io/doc/com.github.cbismuth/junit-repeat-rule)
[![repository](https://maven-badges.herokuapp.com/maven-central/com.github.cbismuth/junit-repeat-rule/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.cbismuth/junit-repeat-rule/)
[![issues](https://img.shields.io/github/issues/cbismuth/junit-repeat-rule.svg)](https://github.com/cbismuth/junit-repeat-rule/issues)
[![licence](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/cbismuth/junit-repeat-rule/master/LICENSE.md)

## Description

A simple JUnit repeat rule written in Java 5+ along with concurrency support.

## Usage

For Maven, add the following dependency:

```xml
<dependency>
    <groupId>com.github.cbismuth</groupId>
    <artifactId>junit-repeat-rule</artifactId>
    <version>1.1.1</version>
</dependency>
```

For Gradle, use:

```gradle
compile 'com.github.cbismuth:junit-repeat-rule:1.1.1'
```

Add the `RepeatRule` to your test class and annotate your test case with `@Repeat` as shown below.

```java
/** A test class containing a repeated test case. */
public class RepeatedTest {
    /** The rule to enable test repetition. */
    @Rule
    public RepeatRule rule = new RepeatRule();
    
    /** A repeated test case. */
    @Test
    @Repeat(times = 3, threads = 4)
    public void testRepetition() {
        // do something
    }
}
```

## Credits

Written by Christophe Bismuth, licensed under the [The MIT License (MIT)](LICENSE.md).
Original design by [Frank Appel](http://www.codeaffine.com/).
Thanks to [Kisty](https://github.com/Kisty) for its contributions.
