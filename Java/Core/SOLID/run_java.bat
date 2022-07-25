@ECHO OFF
set JAVA_PATH=C:\Program Files\BellSoft\LibericaJDK-11\bin
call "%JAVA_PATH%\javac" %1\Main.java -encoding utf-8
call "%JAVA_PATH%\java" %1.Main
