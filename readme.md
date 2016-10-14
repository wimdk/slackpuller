
A small project to pull messages from slack and push to a kafka topic

to connect to slack you have to add your token as an environment variable :
export SLACKTOKEN=*your-slack-tocken*

slackdata will be pushed to kafka.
Download kafka and follow simple install guide on https://kafka.apache.org/documentation#quickstart

From your kafka root-dir create a topic :
*bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic ChannelTopic*

*gradle build*

*gradle run*

in your browser go to [localhost:8080/Channels](http://localhost:8080/Channels)





