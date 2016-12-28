package cn.szssha.yunba.task;

import cn.szssha.yunba.listener.PublishListener;
import cn.szssha.yunba.util.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * Created by mirsery on 28/12/2016.
 */
public class PublishTask {

    //private static Logger logger = LoggerFactory.getLogger(PublishTask.class);

    public static void Publish(String url, String message, PublishListener listener) {

        String result = new HttpRequest().sendPost(url, message);
        try {
            JSONObject json = new JSONObject(result);
            int status = (Integer) json.get("status");
            /**由于YunBa返回的json格式的问题,这边重新定义下*/
            String content = "";
            switch (status) {
                case -1:
                    content = "Can not get status from YunBa Server!";
                    // logger.error(content);
                    listener.onError(status, content);
                    break;
                case 0:
                    content = "Publish the message success!";
                    // logger.info("Publish the message success!");
                    listener.onSuccess(content);
                    break;
                case 1:
                    content = "invalid parameters";
                    //logger.error(content);
                    listener.onError(status, content);
                    break;
                case 2:
                    content = "internal server";
                    // logger.error(content);
                    listener.onError(status, content);
                    break;
                case 3:
                    content = "no request application";
                    // logger.error(content);
                    listener.onError(status, content);
                    break;
                case 4:
                    content = "timeout";
                    // logger.error(content);
                    listener.onError(status, content);
                    break;
                case 5:
                    content = "alias not found";
                    // logger.error(content);
                    listener.onError(status, content);
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
