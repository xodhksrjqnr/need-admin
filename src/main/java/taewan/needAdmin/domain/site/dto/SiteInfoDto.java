package taewan.needAdmin.domain.site.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SiteInfoDto {

    private Integer id;
    private String name;
    private String url;
    private String postsTag;
    private String pageListTag;
    private String subjectTag;
    private String recentPostTag;
    private String dateTag;
    private String postViewTag;
}
