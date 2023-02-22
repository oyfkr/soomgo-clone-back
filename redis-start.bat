echo "Down Redis Docker Container ..."
docker-compose -f ./docker-compose-redis.yml down
echo "Up Redis Docker Container ..."
docker-compose -f ./docker-compose-redis.yml up --build -d