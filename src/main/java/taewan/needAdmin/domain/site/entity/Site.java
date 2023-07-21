package taewan.needAdmin.domain.site.entity;

import jakarta.persistence.*;
import lombok.*;
import taewan.needAdmin.domain.site.dto.SiteInfoDto;

@Entity
@Getter
@Table(name = "sites")
@NoArgsConstructor
public class Site {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String url;
    private String postsTag;
    private String pageListTag;
    private String subjectTag;
    private String recentPostTag;
    private String dateTag;

    @Builder
    private Site(String name, String url, String postsTag, String pageListTag, String subjectTag, String recentPostTag, String dateTag) {
        this.name = name;
        this.url = url;
        this.postsTag = postsTag;
        this.pageListTag = pageListTag;
        this.subjectTag = subjectTag;
        this.recentPostTag = recentPostTag;
        this.dateTag = dateTag;
    }

    public SiteInfoDto toInfoDto() {
        return SiteInfoDto.builder()
                .id(id)
                .name(name)
                .url(url)
                .postsTag(postsTag)
                .pageListTag(pageListTag)
                .subjectTag(subjectTag)
                .recentPostTag(recentPostTag)
                .dateTag(dateTag)
                .build();
    }
}
