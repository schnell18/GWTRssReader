# Introduction
This is a sample GWT/GXT application to showcase the basic building
blocks to construct rich internet application using Java, Gradle, Jetty
etc.

This sample project employs structural gradle to build and test. Make
sure you have gradle installed.

# How to create a release war?
Run this command under top level directory of the project:

    gradle clean release

# How to launch the GWT devmode?
Run this command under top level directory of the project:

    gradle devMode

# How to run the project using an embedded servlet container?
This project supports both jetty and tomcat as embedded servlet
container, which means you do not need install either Jetty or Tomcat in
advance. Run this command under top level directory of the project to
use Jetty:

    gradle jettyRun

Run this command to use Tomcat:

    gradle tomcatRun

