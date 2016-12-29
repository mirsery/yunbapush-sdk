package cn.szssha.yunba;

import cn.szssha.yunba.listener.PublishListener;
import cn.szssha.yunba.util.PublishType;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mirsery on 28/12/2016.
 */
public class YunBaClientFactoryTest {

    private static YunBaClient client = null;
    private static Logger logger = LoggerFactory.getLogger(YunBaClientFactoryTest.class);

    @Before
    public void init() {
        String url = "http://rest.yunba.io:8080";
        String appkey = "5861c3e1b09557a45c143b43";
        String seckey = "sec-T7q6QGcVGWVtV0CxX4wmWWxDJrDL2avznNQjZOzGRYChDUsd";

        client = YunBaClientFactory.getInstance(url, appkey, seckey);
    }

    @Test
    public void testPublishTopic() {
        client.publishTOTopic(PublishType.PUBLISH, "异步推送测试", "SDK-TEST", new PublishListener() {
            public void onSuccess(String content) {
                logger.info(content);
            }

            public void onError(int status, String content) {
                logger.error(content);
            }
        });
        try {
            Thread.sleep(3 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPublishTopicASync() {
        client.publishTOTopic(PublishType.PUBLISH_ASYNC, "同步推送测试", "SDK-TEST", new PublishListener() {
            public void onSuccess(String content) {
                logger.info(content);
            }

            public void onError(int status, String content) {
                logger.error(content);
            }
        });
        try {
            Thread.sleep(3 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPublishAlias(){
        client.publishToAlias(PublishType.PUBLISH_TO_ALIAS, "publish to alias", "alias", new PublishListener() {
            @Override
            public void onSuccess(String content) {
                logger.info(content);
            }

            @Override
            public void onError(int status, String content) {
                logger.error(content);
            }
        });
        try {
            Thread.sleep(3 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}