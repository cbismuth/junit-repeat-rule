#!/usr/bin/env bash

set +x
set -e

if [ ! -z "$TRAVIS_TAG" ]
then
    echo "Git tag detected - set Maven POM version to [$TRAVIS_TAG]"
    mvn --settings $DEPLOY_DIR/maven/settings.xml versions:set -DnewVersion=$TRAVIS_TAG 1>/dev/null 2>/dev/null
else
    echo "No Git tag detected - keep Maven POM version untouched"
fi

mvn --settings $DEPLOY_DIR/maven/settings.xml -P ossrh clean deploy -B -U
