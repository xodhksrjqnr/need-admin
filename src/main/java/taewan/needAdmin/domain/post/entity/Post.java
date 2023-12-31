package taewan.needAdmin.domain.post.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import taewan.needAdmin.domain.benefit.entity.Benefit;
import taewan.needAdmin.domain.job.entity.Job;
import taewan.needAdmin.domain.post.dto.PostInfoDto;
import taewan.needAdmin.domain.post.dto.PostSimpleInfoDto;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Table(name = "posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String title;
    private String thumbnail;
    private String url;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "benefit_id")
    private Benefit benefit;
    private String administrativeDistrict;
    private String sex;
    @Column(columnDefinition = "tinyint(1) default 0")
    private boolean status;
    private LocalDateTime closingDate;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Builder
    private Post(String title, String thumbnail, String url, Job job, Benefit benefit, String sex,
                 boolean status, String administrativeDistrict, LocalDateTime closingDate) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.url = url;
        this.job = job;
        this.benefit = benefit;
        this.sex = sex;
        this.administrativeDistrict = administrativeDistrict;
        this.closingDate = closingDate;
    }

    public PostInfoDto toInfoDto(List<String> conditions) {
        return PostInfoDto.builder()
                .postId(postId)
                .title(title)
                .thumbnail(thumbnail)
                .url(url)
                .conditions(conditions)
                .status(status ? "공개" : "비공개")
                .closingDate(closingDate)
                .createdDate(createdDate)
                .build();
    }

    public PostSimpleInfoDto toInfoDto() {
        return PostSimpleInfoDto.builder()
                .postId(postId)
                .title(title)
                .url(url)
                .status(status ? "공개" : "비공개")
                .closingDate(closingDate)
                .createdDate(createdDate)
                .build();
    }

    public void activeChange() {
        status = !status;
    }
}
