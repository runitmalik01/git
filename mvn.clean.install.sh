#!/bin/bash
mkdir -p ~/data
mkdir -p ~/data/cmsrepositories
mkdir -p ~/data/cmsrepositories/indiantaxonline
mvn  -DskipTests -Dmvn.test.skip=true -Drepo.path=~/data/cmsrepositories/indiantaxonline clean install
