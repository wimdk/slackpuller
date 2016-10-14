package be.cegeka.slacktract.slackpuller;

import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;
import spark.route.RouteOverview;

import java.io.IOException;

import static spark.Spark.*;

public class SlackPuller {
    public static SlackSession session;

    public static void main(String[] args) throws IOException {

        configureSpark();

        startSlackSession(System.getenv("SLACKTOKEN"));


        get("/Channels", ChannelController.getChannels);
    }

    private static void configureSpark() {
        port(8080);
        RouteOverview.enableRouteOverview();
    }

    private static void startSlackSession(String slackToken) throws IOException {
        session = SlackSessionFactory.createWebSocketSlackSession(slackToken);
        session.connect();
        System.out.println("Slacksession created");
    }
}