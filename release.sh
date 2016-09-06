#!/usr/bin/env bash

set -e

if [ "$#" -ne 2 ]; then
    echo "Illegal number of parameters, usage: 'release.sh <tag_version> <next_version>'."
    exit 128
fi

git reset --hard HEAD

mvn -q clean install

mvn -q versions:set -DnewVersion=$1
mvn -q clean install

git add pom.xml

git commit -m "[release] Prepare release '$1'."
git tag "$1"

mvn -q versions:set -DnewVersion=$2
mvn -q clean install

git add pom.xml

git commit -m "[release] Prepare next development iteration '$2'."

git push
git push --tag

git reset --hard HEAD

rm pom.xml.versionsBackup
