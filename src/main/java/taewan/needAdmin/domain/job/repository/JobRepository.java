package taewan.needAdmin.domain.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.needAdmin.domain.job.entity.Job;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {

    Optional<Job> findByName(String name);
}
