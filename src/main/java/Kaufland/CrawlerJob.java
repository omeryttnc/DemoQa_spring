package Kaufland;

import java.util.Map;

public class CrawlerJob implements Serilizable {
    private long id;
    private Long mappingid;
    private long shopid;
    private Map<String,String> cookie;

    public CrawlerJob(long id, Long mappingid, long shopid, Map<String, String> cookie) {
        this.id = id;
        this.mappingid = mappingid;
        this.shopid = shopid;
        this.cookie = cookie;
    }

    public long getId() {
        return id;
    }

    public Long getMappingid() {
        return mappingid;
    }

    public long getShopid() {
        return shopid;
    }

    public Map<String, String> getCookie() {
        return cookie;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMappingid(Long mappingid) {
        this.mappingid = mappingid;
    }

    public void setShopid(long shopid) {
        this.shopid = shopid;
    }

    public void setCookie(Map<String, String> cookie) {
        this.cookie = cookie;
    }

    @Override
    public String toString() {
        return "CrawlerJob{" +
                "id=" + id +
                ", mappingid=" + mappingid +
                ", shopid=" + shopid +
                ", cookie=" + cookie +
                '}';
    }
}
