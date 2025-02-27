mvn clean verify -f ../bidding-service
docker build -t bidding/bidding-db-changelog-job:latest ../bidding-service/bidding-db-changelog-job
docker build -t bidding/bidding-server:latest ../bidding-service/bidding-server
