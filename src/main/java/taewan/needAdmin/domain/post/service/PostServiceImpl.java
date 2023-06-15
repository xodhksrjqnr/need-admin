package taewan.needAdmin.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.needAdmin.domain.benefit.entity.Benefit;
import taewan.needAdmin.domain.benefit.repository.BenefitRepository;
import taewan.needAdmin.domain.job.entity.Job;
import taewan.needAdmin.domain.job.repository.JobRepository;
import taewan.needAdmin.domain.post.dto.PostSimpleInfoDto;
import taewan.needAdmin.domain.post.dto.PostUploadForm;
import taewan.needAdmin.domain.post.entity.Post;
import taewan.needAdmin.domain.post.repository.PostRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final JobRepository jobRepository;
    private final BenefitRepository benefitRepository;

    @Override
    public List<PostSimpleInfoDto> findAllWithSortedDESC() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"))
                .stream().map(Post::toInfoDto).toList();
    }

    @Transactional(readOnly = false)
    @Override
    public void upload(PostUploadForm form) {
        Benefit benefit = benefitRepository.findByName(form.getBenefit())
                .orElseGet(() -> benefitRepository.save(new Benefit(form.getBenefit())));
        Job job = jobRepository.findByName(form.getJob())
                .orElseGet(() -> jobRepository.save(new Job(form.getJob())));

        postRepository.save(form.toEntity(job, benefit));
    }

    @Transactional(readOnly = false)
    @Override
    public void activeChange(Long postId) {
        postRepository.findById(postId)
                .orElseThrow(NoSuchElementException::new)
                .activeChange();
    }
}
