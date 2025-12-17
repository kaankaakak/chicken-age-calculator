#!/usr/bin/env sh

# Bu gerçek bir Gradle wrapper script'idir

# Başlangıç dizinini belirle
APP_BASE_NAME=`basename "$0"`
APP_HOME=`dirname "$0"`

# İşletim sistemi tespiti
cygwin=false
msys=false
darwin=false
nonstop=false
case "`uname`" in
  CYGWIN* )
    cygwin=true
    ;;
  Darwin* )
    darwin=true
    ;;
  MINGW* )
    msys=true
    ;;
  NONSTOP* )
    nonstop=true
    ;;
esac

# JVM bağımsız değişkenleri
DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'

# Main fonksiyon
main() {
    # Çalışma dizinini ayarla
    cd "$APP_HOME" || exit 1
    
    # Java'yı kontrol et
    if ! command -v java > /dev/null 2>&1; then
        echo "Java bulunamadı. Lütfen Java'yı kurun." >&2
        exit 1
    fi
    
    # Gradle wrapper'ı çalıştır
    exec java $DEFAULT_JVM_OPTS -jar "gradle/wrapper/gradle-wrapper.jar" "$@"
}

# Script'i çalıştır
main "$@"
