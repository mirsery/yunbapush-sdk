package cn.szssha.yunba.model;

/**
 * Created by mirsery on 28/12/2016.
 */
public class OptionsModel {
    private int timeToLive;
    private int qos;
    private APSModel apnJson;

    public OptionsModel(int timeToLive, int qos, APSModel apnJson) {
        this.timeToLive = timeToLive;
        this.qos = qos;
        this.apnJson = apnJson;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public int getQos() {
        return qos;
    }

    public void setQos(int qos) {
        this.qos = qos;
    }

    public APSModel getApnJson() {
        return apnJson;
    }

    public void setApnJson(APSModel apnJson) {
        this.apnJson = apnJson;
    }
}