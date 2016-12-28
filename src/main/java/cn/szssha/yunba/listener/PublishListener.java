package cn.szssha.yunba.listener;

/**
 * Created by mirsery on 28/12/2016.
 */
public interface PublishListener {
    /**推送成功时调用*/
    public void onSuccess(String content);
    /**推送失败时调用*/
    public void onError(int status,String content);
}
