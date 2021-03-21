echo "------Removing images--------"
docker rmi $(docker images -q);
