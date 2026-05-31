@echo off
set JAVA_HOME=C:\Program Files\Microsoft\jdk-21.0.11
set PATH=%JAVA_HOME%\bin;%PATH%
cd /d D:\DAWII_T1_i202331381\SOAP\Proj-CRUD-SOAP
.\mvnw.cmd compile -q
