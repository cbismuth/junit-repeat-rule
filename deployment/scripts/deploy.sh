#!/usr/bin/env bash

set +x
set -e

if [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    mvn -X -Dgpg.passphrase=${GPG_PASSPHRASE} deploy -P sign,build-extras --settings $TRAVIS_BUILD_DIR/deployment/maven/settings.xml
fi
