package taewan.needAdmin.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import taewan.needAdmin.domain.benefit.repository.BenefitRepository;
import taewan.needAdmin.domain.benefit.service.BenefitService;
import taewan.needAdmin.domain.benefit.service.BenefitServiceImpl;
import taewan.needAdmin.domain.job.repository.JobRepository;
import taewan.needAdmin.domain.job.service.JobService;
import taewan.needAdmin.domain.job.service.JobServiceImpl;
import taewan.needAdmin.domain.post.repository.PostRepository;
import taewan.needAdmin.domain.post.service.PostService;
import taewan.needAdmin.domain.post.service.PostServiceImpl;
import taewan.needAdmin.domain.site.repository.SiteRepository;
import taewan.needAdmin.domain.site.service.SiteService;
import taewan.needAdmin.domain.site.service.SiteServiceImpl;
import taewan.needAdmin.global.utils.AutoUpload;

@Configuration
@EnableJpaAuditing
@RequiredArgsConstructor
public class AppConfig {

    private final PostRepository postRepository;
    private final BenefitRepository benefitRepository;
    private final JobRepository jobRepository;
    private final SiteRepository siteRepository;

    @Bean
    public PostService postService() {
        return new PostServiceImpl(postRepository, jobRepository, benefitRepository);
    }

    @Bean
    public JobService jobService() {
        return new JobServiceImpl(jobRepository);
    }

    @Bean
    public BenefitService benefitService() {
        return new BenefitServiceImpl(benefitRepository);
    }

    @Bean
    public SiteService siteService() {
        return new SiteServiceImpl(siteRepository, new AutoUpload());
    }
}
