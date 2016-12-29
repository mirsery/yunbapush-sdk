package cn.szssha.yunba.util;

/**
 * Created by mirsery on 28/12/2016.
 */
public enum PublishType {

    PUBLISH(0), PUBLISH_TO_ALIAS(1), PUBLISH_TO_ALIAS_BATCH(2), PUBLISH_ASYNC(4);

    private int index;

    PublishType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
