@rem Licensed to the Apache Software Foundation (ASF)
@rem Gradle wrapper batch script

@echo off
setlocal enabledelayedexpansion

set "APP_HOME=%~dp0"
set "APP_BASE_NAME=%~n0"
set "CLASSPATH=%APP_HOME%gradle\wrapper\gradle-wrapper.jar"

java -cp "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*

:end
endlocal &amp; exit /b %ERRORLEVEL%
