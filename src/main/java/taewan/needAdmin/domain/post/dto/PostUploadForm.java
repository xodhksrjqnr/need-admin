package taewan.needAdmin.domain.post.dto;

import lombok.Getter;
import lombok.Setter;
import taewan.needAdmin.domain.benefit.entity.Benefit;
import taewan.needAdmin.domain.job.entity.Job;
import taewan.needAdmin.domain.post.entity.Post;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostUploadForm {

    private String title;
    private String thumbnail;
    private String url;
    private String job;
    private String benefit;
    private String administrativeDistrict;
    private String sex;
    private LocalDateTime closingDate;

    public Post toEntity(Job job, Benefit benefit) {
        return Post.builder()
                .title(title)
                .thumbnail(thumbnail)
                .url(url)
                .job(job)
                .benefit(benefit)
                .sex(sex)
                .administrativeDistrict(administrativeDistrict)
                .closingDate(closingDate)
                .build();
    }

    @Override
    public String toString() {
        return "PostUploadForm{" +
                "title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", url='" + url + '\'' +
                ", job='" + job + '\'' +
                ", benefit='" + benefit + '\'' +
                ", administrativeDistrict='" + administrativeDistrict + '\'' +
                ", sex='" + sex + '\'' +
                ", closingDate=" + closingDate +
                '}';
    }
}
