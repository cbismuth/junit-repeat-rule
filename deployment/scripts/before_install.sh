#!/usr/bin/env bash

if [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    openssl aes-256-cbc -K $encrypted_0b8b24b83425_key -iv $encrypted_0b8b24b83425_iv -in $TRAVIS_BUILD_DIR/deployment/crypto/codesigning.asc.enc -out $TRAVIS_BUILD_DIR/deployment/crypto/codesigning.asc -d
    gpg --fast-import $TRAVIS_BUILD_DIR/deployment/crypto/codesigning.asc
fi
