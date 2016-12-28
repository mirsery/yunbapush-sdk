package cn.szssha.yunba;

import cn.szssha.yunba.listener.PublishListener;
import cn.szssha.yunba.util.PublishType;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mirsery on 28/12/2016.
 */
public class YunBaClientFactoryTest {

    private static YunBaClient client = null;

    @Before
    public void init() {
        String url = "http://rest.yunba.io:8080";
        String appkey = "5861c3e1b09557a45c143b43";
        String seckey = "sec-T7q6QGcVGWVtV0CxX4wmWWxDJrDL2avznNQjZOzGRYChDUsd";

        client = YunBaClientFactory.getInstance(url, appkey, seckey);
    }

    @Test
    public void testPublishTopic() {
        client.publishTOTopic(PublishType.PUBLISH, "来吧中文乱码", "SDK-TEST", new PublishListener() {
            public void onSuccess(String content) {
                System.out.print(content);
            }

            public void onError(int status, String content) {
                System.out.print(content);
            }
        });
        try {
            Thread.sleep(4 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPublishTopicASync() {
        client.publishTOTopic(PublishType.PUBLISH_ASYNC, "来吧中文乱码", "SDK-TEST", new PublishListener() {
            public void onSuccess(String content) {
                System.out.println(content);
            }

            public void onError(int status, String content) {
                System.out.println(content);
            }
        });
        try {
            Thread.sleep(4 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}