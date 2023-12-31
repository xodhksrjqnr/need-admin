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

@Configuration
@EnableJpaAuditing
@RequiredArgsConstructor
public class AppConfig {

    private final PostRepository postRepository;
    private final BenefitRepository benefitRepository;
    private final JobRepository jobRepository;

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
}
