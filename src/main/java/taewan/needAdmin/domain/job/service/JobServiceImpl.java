package taewan.needAdmin.domain.job.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.needAdmin.domain.job.entity.Job;
import taewan.needAdmin.domain.job.repository.JobRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Transactional(readOnly = false)
    @Override
    public void save(String name) {
        if (jobRepository.findByName(name).isEmpty()) {
            jobRepository.save(new Job(name));
        }
    }

    @Override
    public List<String> findAll() {
        return jobRepository.findAll()
                .stream().map(Job::getName)
                .toList();
    }
}
