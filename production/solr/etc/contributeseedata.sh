#!/bin/bash

p=`pwd`/
find ./seeddata/ -name *.csv -exec echo {} \; -exec curl http://localhost:8080/site/solr/bankdata/update/csv?stream.file=$p{} \;
