package com.mfq.bean;

public class WechatEvent {
    private Integer eventId;

    private Integer type;

    private String imageMediaId;

    private String mediaMediaId;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImageMediaId() {
        return imageMediaId;
    }

    public void setImageMediaId(String imageMediaId) {
        this.imageMediaId = imageMediaId == null ? null : imageMediaId.trim();
    }

    public String getMediaMediaId() {
        return mediaMediaId;
    }

    public void setMediaMediaId(String mediaMediaId) {
        this.mediaMediaId = mediaMediaId == null ? null : mediaMediaId.trim();
    }
}