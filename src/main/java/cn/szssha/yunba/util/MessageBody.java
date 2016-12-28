package cn.szssha.yunba.util;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONWriter;

import java.util.List;

/**
 * Created by mirsery on 28/12/2016.
 */
public class MessageBody {

    public String getTopicMessageBody(String method, String appKey, String seckey,
                                      String topic, String msg) {

        JSONWriter jsonStringer = new JSONStringer();
        try {
            jsonStringer.object();

            jsonStringer.key("method").value(method)
                    .key("appkey").value(appKey)
                    .key("seckey").value(seckey)
                    .key("topic").value(topic)
                    .key("msg").value(msg);
            jsonStringer.endObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStringer.toString();
    }

    public String getTopicMessageBody(String method, String appKey, String seckey,
                                      String topic, String msg, int time_to_live,
                                      int qos) {

        JSONWriter jsonStringer = new JSONStringer();
        try {
            jsonStringer.object();

            jsonStringer.key("method")
                    .value(method).key("appkey")
                    .value(appKey).key("seckey")
                    .value(seckey).key("topic")
                    .value(topic).key("msg")
                    .value(msg)
                    .key("opts").value(new JSONObject().
                    put("time_to_live", time_to_live).
                    put("qos", qos));
            jsonStringer.endObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStringer.toString();
    }

    public String getTopicMessageBody(String method, String appKey, String seckey,
                                      String topic, String msg, int time_to_live,
                                      int qos, String alert, int badge, String sound, int contentAvailable) {
        JSONWriter jsonStringer = new JSONStringer();
        try {
            jsonStringer.object();

            jsonStringer.key("method")
                    .value(method).key("appkey")
                    .value(appKey).key("seckey")
                    .value(seckey).key("topic")
                    .value(topic).key("msg")
                    .value(msg)
                    .key("opts").value(new JSONObject().
                    put("time_to_live", time_to_live).
                    put("qos", qos).
                    put("apn_json",
                            new JSONObject().put("aps",
                                    new JSONObject().
                                            put("alert", alert).
                                            put("badge", badge).
                                            put("sound", sound).
                                            put("content_available", contentAvailable))));
            jsonStringer.endObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStringer.toString();
    }

    public String getAliasMessageBody(String method, String appKey, String seckey,
                                      String alias, String msg) {

        JSONWriter jsonStringer = new JSONStringer();
        try {
            jsonStringer.object();

            jsonStringer.key("method").value(method)
                    .key("appkey").value(appKey)
                    .key("seckey").value(seckey)
                    .key("alias").value(alias)
                    .key("msg").value(msg);
            jsonStringer.endObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStringer.toString();
    }

    public String getAliasMessageBody(String method, String appKey, String seckey,
                                      String alias, String msg, int time_to_live,
                                      int qos) {

        JSONWriter jsonStringer = new JSONStringer();
        try {
            jsonStringer.object();

            jsonStringer.key("method")
                    .value(method).key("appkey")
                    .value(appKey).key("seckey")
                    .value(seckey).key("alias")
                    .value(alias).key("msg")
                    .value(msg)
                    .key("opts").value(new JSONObject().
                    put("time_to_live", time_to_live).
                    put("qos", qos));
            jsonStringer.endObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStringer.toString();
    }

    public String getAliasMessageBody(String method, String appKey, String seckey,
                                      String alias, String msg, int time_to_live,
                                      int qos, String alert, int badge, String sound, int contentAvailable) {
        JSONWriter jsonStringer = new JSONStringer();
        try {
            jsonStringer.object();

            jsonStringer.key("method")
                    .value(method).key("appkey")
                    .value(appKey).key("seckey")
                    .value(seckey).key("alias")
                    .value(alias).key("msg")
                    .value(msg)
                    .key("opts").value(new JSONObject().
                    put("time_to_live", time_to_live).
                    put("qos", qos).
                    put("apn_json",
                            new JSONObject().put("aps",
                                    new JSONObject().
                                            put("alert", alert).
                                            put("badge", badge).
                                            put("sound", sound).
                                            put("content_available", contentAvailable))));
            jsonStringer.endObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStringer.toString();
    }

    public String getAliasBatchMessageBody(String method, String appKey, String seckey,
                                           List<String> aliasList, String msg) {

        JSONWriter jsonStringer = new JSONStringer();
        try {
            JSONArray aliases = new JSONArray();
            for (String alias : aliasList) {
                aliases.put(alias);
            }
            jsonStringer.object();

            jsonStringer.key("method").value(method)
                    .key("appkey").value(appKey)
                    .key("seckey").value(seckey)
                    .key("aliases").value(aliases)
                    .key("msg").value(msg);

            jsonStringer.endObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStringer.toString();
    }

    public String getAliasBatchMessageBody(String method, String appKey, String seckey,
                                           List<String> aliasList, String msg, int time_to_live,
                                           int qos) {

        JSONWriter jsonStringer = new JSONStringer();
        try {
            JSONArray aliases = new JSONArray();
            for (String alias : aliasList) {
                aliases.put(alias);
            }

            jsonStringer.object();

            jsonStringer.key("method").value(method)
                    .key("appkey").value(appKey)
                    .key("seckey").value(seckey)
                    .key("alises").value(aliases)
                    .key("msg").value(msg)
                    .key("opts").value(new JSONObject().
                    put("time_to_live", time_to_live).
                    put("qos", qos));
            jsonStringer.endObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStringer.toString();
    }

    public String getAliasBatchMessageBody(String method, String appKey, String seckey,
                                           List<String> aliasList, String msg, int time_to_live,
                                           int qos, String alert, int badge, String sound, int contentAvailable) {

        JSONWriter jsonStringer = new JSONStringer();
        try {
            JSONArray aliases = new JSONArray();
            for (String alias : aliasList) {
                aliases.put(alias);
            }

            jsonStringer.object();

            jsonStringer.key("method").value(method)
                    .key("appkey").value(appKey)
                    .key("seckey").value(seckey)
                    .key("aliases").value(aliases)
                    .key("msg").value(msg)
                    .key("opts").value(new JSONObject().
                    put("time_to_live", time_to_live).
                    put("qos", qos).
                    put("apn_json",
                            new JSONObject().put("aps",
                                    new JSONObject().
                                            put("alert", alert).
                                            put("badge", badge).
                                            put("sound", sound).
                                            put("content_available", contentAvailable))));

            jsonStringer.endObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStringer.toString();
    }
}