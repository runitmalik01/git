set CURL=C:\Users\admin\Projects\utilities\curl.exe

http://mootlybuilds.zapto.org:8080/site/solr/admin/cores?action=CREATE&name=collection1&instanceDir=collection1&config=solrconfig.xml&schema=schema.xml&dataDir=data


%CURL% http://mootlybuilds.zapto.org:8080/site/solr/update/csv?stream.file=C:\Users\mootly\Documents\solr_home\IFCB2009_01.csv
%CURL% http://mootlybuilds.zapto.org:8080/site/solr/update/csv?stream.file=C:\Users\mootly\Documents\solr_home\IFCB2009_08.csv


%CURL% http://localhost:8080/site/solr/update/csv?stream.file=C:\Users\admin\Downloads\BankIFSCCode\IFCB2009_01_SBI.csv

%CURL% http://localhost:8080/site/solr/update/csv?stream.file=C:\Users\admin\Downloads\BankIFSCCode\IFCB2009_05_AXIS.csv



%CURL% http://localhost:8080/site/solr/bankdata/update/csv?stream.file=C:\Users\admin\Downloads\IFCB2009_01.csv
%CURL% http://localhost:8080/site/solr/bankdata/update/csv?stream.file=C:\Users\admin\Downloads\IFCB2009_08.csv
