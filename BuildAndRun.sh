#!/bin/sh
mvn clean package
java -jar ./target/loginForm-1.0-SNAPSHOT.jar
