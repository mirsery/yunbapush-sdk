package cn.szssha.yunba.model;

/**
 * Created by mirsery on 28/12/2016.
 */
public class APSModel {
    private String alert;
    private int badge;
    private String sound;
    private int contentAvailable;

    public APSModel(String alert, int badge, String sound, int contentAvailable) {
        this.alert = alert;
        this.badge = badge;
        this.sound = sound;
        this.contentAvailable = contentAvailable;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public int getContentAvailable() {
        return contentAvailable;
    }

    public void setContentAvailable(int contentAvailable) {
        this.contentAvailable = contentAvailable;
    }
}