SET JAVA_HOME=C:\Program Files\Java\jdk1.7.0_45
set MAVEN_OPTS=-Xmx1024M
mvn -e -DcontrolFY=true -DFY.2012.enabled=true  -P cargo.run -Dcargo.maven.containerId=tomcat7x -Dcargo.maven.containerUrl=http://www.bizdirusa.com/mirrors/apache/tomcat/tomcat-7/v7.0.47/bin/apache-tomcat-7.0.47.zip -Drepo.path=C:\Users\Amit\Projects\cmsrepositories\indiantaxonline 
REM -Dcargo.debug.address=9003 -Dcargo.debug.suspend=y
REM mvn -e -DcontrolFY=true -DFY.2012.enabled=true  -P cargo.run -Dcargo.maven.containerId=tomcat7x -Dcargo.maven.containerUrl=http://archive.apache.org/dist/tomcat/tomcat-7/v7.0.40/bin/apache-tomcat-7.0.40.zip -Drepo.path=C:\Users\admin\Projects\Mootly\cmsrepositories\hippo-solutions\branch_indiantaxonline 
REM -Dcargo.debug.address=9003 -Dcargo.debug.suspend=y