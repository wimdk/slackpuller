package be.cegeka.slacktract.slackpuller;

import com.ullink.slack.simpleslackapi.SlackChannel;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Collection;

public class ChannelController {
    public static Route getChannels = (Request request, Response response) -> {

        final KafkaProducer<String, String> producer = new KafkaProducerFactory().createProducer();
        final Collection<SlackChannel> channels = SlackPuller.session.getChannels();
        channels.forEach(slackChannel -> System.out.println(slackChannel));
        channels.forEach(slackChannel -> producer.send(new ProducerRecord<String, String>("ChannelTopic", slackChannel.getId(), slackChannel.getName())));
        producer.close();
        return channels;
    };
}
