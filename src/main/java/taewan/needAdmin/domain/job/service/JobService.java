package taewan.needAdmin.domain.job.service;

import java.util.List;

public interface JobService {

    void save(String name);
    List<String> findAll();
}
