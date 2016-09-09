#!/usr/bin/env bash

set +x
set -u
set -e

if [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    mvn -X deploy -P sign,build-extras --settings $TRAVIS_BUILD_DIR/deployment/maven/settings.xml
fi
