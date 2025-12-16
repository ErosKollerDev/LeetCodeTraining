#!/usr/bin/env bash
set -euo pipefail

# Simple build script for JNI demo on Linux
# It will:
# 1) Compile Java class and generate JNI headers
# 2) Compile native library libdemo.so
# 3) Show how to run the demo

PROJECT_ROOT="$(cd "$(dirname "$0")/../../.." && pwd)"
MODULE_DIR="$PROJECT_ROOT"
JAVA_SRC_DIR="$MODULE_DIR/src/main/java"
NATIVE_DIR="$MODULE_DIR/src/main/native"
HEADERS_DIR="$NATIVE_DIR/include"
TARGET_DIR="$MODULE_DIR/target"
NATIVE_BUILD_DIR="$TARGET_DIR/native"
CLASSES_DIR="$TARGET_DIR/classes"

mkdir -p "$HEADERS_DIR" "$NATIVE_BUILD_DIR" "$CLASSES_DIR"

# Detect JAVA_HOME if not set
if [[ -z "${JAVA_HOME:-}" ]]; then
  if command -v /usr/libexec/java_home >/dev/null 2>&1; then
    export JAVA_HOME=$(/usr/libexec/java_home)
  else
    # Try to infer from javac
    JAVAC_PATH=$(command -v javac)
    if [[ -n "$JAVAC_PATH" ]]; then
      JAVA_BIN_DIR=$(dirname "$JAVAC_PATH")
      export JAVA_HOME=$(cd "$JAVA_BIN_DIR/.." && pwd)
    fi
  fi
fi

if [[ -z "${JAVA_HOME:-}" ]]; then
  echo "JAVA_HOME is not set and could not be auto-detected. Please set JAVA_HOME."
  exit 1
fi

echo "Using JAVA_HOME=$JAVA_HOME"

# 1) Compile Java and generate header
pushd "$MODULE_DIR" >/dev/null
  echo "Compiling Java and generating JNI headers..."
  javac -h "$HEADERS_DIR" -d "$CLASSES_DIR" "$JAVA_SRC_DIR/com/jni/Demo.java"
popd >/dev/null

# 2) Build shared library
# Include paths: $JAVA_HOME/include and $JAVA_HOME/include/linux
CFLAGS="-I$JAVA_HOME/include -I$JAVA_HOME/include/linux -I$HEADERS_DIR -fPIC -O2"
LIB_NAME=demo
OUTPUT_SO="$NATIVE_BUILD_DIR/lib${LIB_NAME}.so"

echo "Building $OUTPUT_SO ..."
cc $CFLAGS -shared "$NATIVE_DIR/demo.c" -o "$OUTPUT_SO"

echo "Build complete."

cat <<EOF

How to run:
1) Ensure the JVM can find the native library:
   export LD_LIBRARY_PATH="$NATIVE_BUILD_DIR:\$LD_LIBRARY_PATH"

2) Run the Java demo:
   java -cp "$CLASSES_DIR" com.jni.Demo

Expected output:
   JNI: 7 + 35 = 42
EOF
