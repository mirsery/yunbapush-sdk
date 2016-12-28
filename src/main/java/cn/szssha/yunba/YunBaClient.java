package cn.szssha.yunba;

import cn.szssha.yunba.listener.PublishListener;
import cn.szssha.yunba.model.APSModel;
import cn.szssha.yunba.model.OptionsModel;
import cn.szssha.yunba.task.PublishTask;
import cn.szssha.yunba.util.MessageBody;
import cn.szssha.yunba.util.PublishType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * Created by mirsery on 28/12/2016.
 */
class YunBaClient {

    private static String url = "";

    private static String appKey = "";

    private static String seckey = "";

    private static MessageBody messageBody = null;

    //private static Logger logger = LoggerFactory.getLogger(YunBaClient.class);

    public YunBaClient(String url, String appKey, String seckey) {
        this.url = url;
        this.appKey = appKey;
        this.seckey = seckey;
        this.messageBody = new MessageBody();
    }

    private void Publish(final String message, final PublishListener listener) {

//        logger.info("The url is " + url);
//        logger.info("message boday is " + message);

        new Thread(new Runnable() {
            public void run() {
                PublishTask.Publish(url, message, listener);
            }
        }).start();
    }

    private String publishTypeFilter(PublishType type) {
        String publishType = null;
        switch (type) {
            case PUBLISH:
                publishType = "publish";
                break;
            case PUBLISH_ASYNC:
                publishType = "publish_async";
                break;
            case PUBLISH_TO_ALIAS_BATCH:
                publishType = "publish_to_alias_batch";
                break;
            case PUBLISH_TO_ALIAS:
                publishType = "publish_to_alias";
                break;
        }
        return publishType;
    }

    public void publishTOTopic(PublishType type, String msg, String topic, PublishListener listener) {
        String publishType = publishTypeFilter(type);
        String message = messageBody.getTopicMessageBody(publishType, appKey, seckey, topic, msg);
        Publish(message, listener);
    }

    public void publishTOTopic(PublishType type, String msg, String topic, OptionsModel ots, PublishListener listener) {
        String message = null;

        int qos = ots.getQos();
        int timeToLive = ots.getTimeToLive();

        APSModel aps = ots.getApnJson();
        String publishType = publishTypeFilter(type);

        if (aps == null) {
            message = messageBody.getTopicMessageBody(publishType, appKey, seckey, topic, msg, timeToLive, qos);
        } else {
            String alert = aps.getAlert();
            int badge = aps.getBadge();
            String sound = aps.getSound();
            int contentAvailbale = aps.getContentAvailable();
            message = messageBody.getTopicMessageBody("publish_async", appKey, seckey, topic, msg, timeToLive, qos, alert, badge, sound, contentAvailbale);
        }
        Publish(message, listener);
    }

    public void publishToAlias(PublishType type, String msg, String alias, PublishListener listener) {
        String publishType = publishTypeFilter(type);
        String message = messageBody.getAliasMessageBody(publishType, appKey, seckey, alias, msg);
        Publish(message, listener);
    }

    public void publishToAlias(PublishType type, String msg, String alias, OptionsModel ots, PublishListener listener) {
        String message = null;

        int qos = ots.getQos();
        int timeToLive = ots.getTimeToLive();

        APSModel aps = ots.getApnJson();
        String publishType = publishTypeFilter(type);

        if (aps == null) {
            message = messageBody.getAliasMessageBody(publishType, appKey, seckey, alias, msg, timeToLive, qos);
        } else {
            String alert = aps.getAlert();
            int badge = aps.getBadge();
            String sound = aps.getSound();
            int contentAvailbale = aps.getContentAvailable();
            message = messageBody.getAliasMessageBody(publishType, appKey, seckey, alias, msg, timeToLive, qos, alert, badge, sound, contentAvailbale);
        }
        Publish(message, listener);
    }

    public void publishToAliasBatch(PublishType type, String msg, List<String> alias, PublishListener listener) {
        String publishType = publishTypeFilter(type);
        String message = messageBody.getAliasBatchMessageBody(publishType, appKey, seckey, alias, msg);
        Publish(message, listener);
    }

    public void publishToAliasBatch(PublishType type, String msg, List<String> alias, OptionsModel ots, PublishListener listener) {
        String message = null;

        int qos = ots.getQos();
        int timeToLive = ots.getTimeToLive();

        APSModel aps = ots.getApnJson();
        String publishType = publishTypeFilter(type);

        if (aps == null) {
            message = messageBody.getAliasBatchMessageBody(publishType, appKey, seckey, alias, msg, timeToLive, qos);
        } else {
            String alert = aps.getAlert();
            int badge = aps.getBadge();
            String sound = aps.getSound();
            int contentAvailbale = aps.getContentAvailable();
            message = messageBody.getAliasBatchMessageBody(publishType, appKey, seckey, alias, msg, timeToLive, qos, alert, badge, sound, contentAvailbale);
        }
        Publish(message, listener);
    }
}