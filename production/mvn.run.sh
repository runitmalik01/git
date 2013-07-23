mkdir -p ~/data
mkdir -p ~/data/cmsrepositories
mkdir -p ~/data/cmsrepositories/indiantaxonline
mvn -P cargo.run -Drepo.path=~/data/cmsrepositories/indiantaxonline
