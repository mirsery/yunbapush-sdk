package cn.szssha.yunba;

/**
 * Created by mirsery on 28/12/2016.
 */
public class YunBaClientFactory {

    private static YunBaClient client = null;

    private YunBaClientFactory() {
    }

    /**
     * 加锁保证多线程的安全
     */
    synchronized public static YunBaClient getInstanceSynchronized(String url, String appKey, String seckey) {
        if (client == null) {
            client = new YunBaClient(url, appKey, seckey);
        }
        return client;
    }

    public static YunBaClient getInstance(String url, String appKey, String seckey) {
        if (client == null) {
            client = new YunBaClient(url, appKey, seckey);
        }
        return client;
    }
}