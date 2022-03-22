@ECHO OFF
set JAVA_PATH=C:\Program Files\BellSoft\LibericaJDK-11\bin
call "%JAVA_PATH%\javac" %1\%1.java -cp .\%1\ -encoding utf-8
call "%JAVA_PATH%\java" -cp .\%1 %1 %2
