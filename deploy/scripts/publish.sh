#!/usr/bin/env bash

set +x
set -e

if [ ! -z "$TRAVIS_TAG" ]
then
    echo "Git tag detected - set Maven POM version to [$TRAVIS_TAG]"
    mvn --settings $GPG_DIR/maven/settings.xml org.codehaus.mojo:versions-maven-plugin:2.3:set -DnewVersion=$TRAVIS_TAG 1>/dev/null 2>/dev/null
else
    echo "No Git tag detected - keep Maven POM version untouched"
fi

mvn clean -P ossrh deploy --settings $GPG_DIR/maven/settings.xml -DskipTests=true -B -U
