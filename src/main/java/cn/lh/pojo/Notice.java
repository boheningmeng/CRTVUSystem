package cn.lh.pojo;

import java.util.Date;

public class Notice {
    private String uuid;

    private String title;

    private String content;

    private Integer noticetype;

    private String publisher;

    private Date time;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getNoticetype() {
        return noticetype;
    }

    public void setNoticetype(Integer noticetype) {
        this.noticetype = noticetype;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}