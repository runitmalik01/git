SET JAVA_HOME=C:\Program Files\Java\jdk1.7.0_21
cd site
call mvn -DskipTests=true  install
call copy /Y C:\Users\admin\Projects\Mootly\code\wcm\hippo\solutions\indianonlinetax\branches\indiateam\site\target\site.war C:\Users\admin\Projects\Mootly\code\wcm\hippo\solutions\indianonlinetax\branches\indiateam\target\tomcat6x\webapps\
cd ..
mvn.run.cmd
