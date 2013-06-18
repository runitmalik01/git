@echo off
SET JAVA_HOME=C:\Program Files\Java\jdk1.7.0_21

mvn -Xmx1024M clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Dcargo.maven.containerId=tomcat7x -Dcargo.maven.containerUrl=http://archive.apache.org/dist/tomcat/tomcat-7/v7.0.40/bin/apache-tomcat-7.0.40.zip
    
REM mvn -Dcargo.maven.containerId=tomcat7x -Dcargo.maven.containerUrl=http://archive.apache.org/dist/tomcat/tomcat-7/v7.0.40/bin/apache-tomcat-7.0.40.zip -Drepo.path=C:\Users\admin\Projects\Mootly\cmsrepositories\hippo-solutions\branch_indiantaxonline install