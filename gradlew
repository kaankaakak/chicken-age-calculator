#!/usr/bin/env bash

# Real Gradle wrapper script
set -e

# Determine script location
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

# Check Java
if ! command -v java &> /dev/null; then
    echo "Java not found. Please install Java."
    exit 1
fi

# Run Gradle wrapper
exec java -jar gradle/wrapper/gradle-wrapper.jar "$@"
