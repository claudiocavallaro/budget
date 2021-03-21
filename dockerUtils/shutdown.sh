echo "---------Stopping container----------"
docker stop $(docker ps -a -q);
echo "---------Removing container----------"
docker rm $(docker ps -a -q);
echo "---------Removing network------------"
docker network prune --force;
echo "---------Removing volume-------------"
docker volume rm $(docker volume ls -q);


