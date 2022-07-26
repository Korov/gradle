./gradlew :distributions-full:allDistributionZip -DsocksProxyHost=127.0.0.1 -DsocksProxyPort=1089

./gradlew install -Pgradle_installPath=/home/korov/temp/path/gradle
# 使用自己安装的gardle
mkdir project
cd project
/home/korov/temp/path/gradle/bin/gradle init -Dorg.gradle.daemon=false

测试类
org.gradle.debug.GradleBuildRunner
