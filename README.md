# JUnit repeat rule

[![Build status](https://travis-ci.org/cbismuth/junit-repeat-rule.svg?branch=master)](https://travis-ci.org/cbismuth/junit-repeat-rule)
[![Coverage status](https://coveralls.io/repos/github/cbismuth/junit-repeat-rule/badge.svg?branch=master)](https://coveralls.io/github/cbismuth/junit-repeat-rule?branch=master)
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/cbismuth/junit-repeat-rule/master/LICENSE.md)
[![GitHub issues](https://img.shields.io/github/issues/cbismuth/junit-repeat-rule.svg)](https://github.com/cbismuth/junit-repeat-rule/issues)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.cbismuth/junit-repeat-rule/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.cbismuth/junit-repeat-rule/)

## Description

A simple JUnit repeat rule written in Java 5+ along with concurrency support.

## Usage

Add the following Maven dependency to your project:

```xml
<dependency>
    <groupId>com.github.cbismuth</groupId>
    <artifactId>junit-repeat-rule</artifactId>
    <version>1.1.0</version>
</dependency>
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

## Credits

Written by Christophe Bismuth, licensed under the [The MIT License (MIT)](LICENSE.md).
