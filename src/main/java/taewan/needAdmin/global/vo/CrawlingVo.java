package taewan.needAdmin.global.vo;

import lombok.Getter;

import java.util.Map;

@Getter
public class CrawlingVo {
    private String firstPost;
    private Map<String, String> posts;

    public CrawlingVo(String firstPost, Map<String, String> posts) {
        this.firstPost = firstPost;
        this.posts = posts;
    }
}
