./gradlew :distributions-full:allDistributionZip -DsocksProxyHost=127.0.0.1 -DsocksProxyPort=1089

./gradlew install -Pgradle_installPath=/home/korov/temp/path/gradle
# 使用自己安装的gardle
mkdir project
cd project
/home/korov/temp/path/gradle/bin/gradle init -Dorg.gradle.daemon=false -Dorg.gradle.debug=true

测试类
org.gradle.debug.GradleBuildRunner

开启日志

| **Option**         | **Outputs Log Levels**                       |
| ------------------ | -------------------------------------------- |
| no logging options | LIFECYCLE and higher                         |
| `-q` or `--quiet`  | QUIET and higher                             |
| `-w` or `--warn`   | WARN and higher                              |
| `-i` or `--info`   | INFO and higher                              |
| `-d` or `--debug`  | DEBUG and higher (that is, all log messages) |

