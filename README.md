# JUnit repeat rule

[![Build Status](https://travis-ci.org/cbismuth/junit-repeat-rule.svg?branch=master)](https://travis-ci.org/cbismuth/junit-repeat-rule)
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/cbismuth/junit-repeat-rule/master/LICENSE.md)
[![GitHub issues](https://img.shields.io/github/issues/cbismuth/junit-repeat-rule.svg)](https://github.com/cbismuth/junit-repeat-rule/issues)

## Description

A simple JUnit repeat rule written in Java 5+ along with concurrency support.

## Usage

```java
public class RepeatedTest {
    @Rule
    public RepeatRule rule = new RepeatRule();
    
    @Test
    @Repeat(times = 3, threads = 4)
    public void testRepetition() {
        // do something
    }
}
```

## Credits

Written by Christophe Bismuth, licensed under the [The MIT License (MIT)](LICENSE.md).
