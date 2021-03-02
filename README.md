## Run Kafka cluster

```bash
docker pull spotify/kafka
docker run -d -p 2181:2181 -p 9092:9092 --env ADVERTISED_HOST=localhost --env ADVERTISED_PORT=9092 --name kafka spotify/kafka
```

Set `ADVERTISED_HOST` to `localhost` if you run producers/consumers from your host machine or the hostname, ex. `kafka` if you run them from the container.


## Create a topic

```bash
docker exec kafka /opt/kafka_2.11-0.10.1.0/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
```


## List topics

```bash
docker exec kafka /opt/kafka_2.11-0.10.1.0/bin/kafka-topics.sh --list --zookeeper localhost:2181
```

## For more
https://gist.github.com/abacaphiliac/f0553548f9c577214d16290c2e751071
