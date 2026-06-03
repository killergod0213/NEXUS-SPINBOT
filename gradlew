#!/usr/bin/env bash
# Licensed to the Apache Software Foundation (ASF)
# Gradle wrapper script

set -e

PRG="$0"
DIRNAME=$(cd "$(dirname "$PRG")" >/dev/null && pwd)
APP_BASE_NAME=$(basename "$0" .sh)

APP_HOME="$( cd "$DIRNAME/.." && pwd -P )"

# Set up the environment
CLASSPATH="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"

exec java -cp "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
