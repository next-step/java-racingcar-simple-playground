#!/bin/bash
"/c/Program Files/Java/jdk-21.0.11/bin/java" -jar style/checkstyle-13.8.0-all.jar \
  -c style/wooteco_checks.xml \
  src/main/java src/test/java

if [ $? -eq 0 ]; then
    echo "✅️ Checkstyle 통과!"
    exit 0
else
    echo "⚠️ Checkstyle 실패!"
    exit 1
fi
