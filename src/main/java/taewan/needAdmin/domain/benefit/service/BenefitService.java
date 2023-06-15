package taewan.needAdmin.domain.benefit.service;

import java.util.List;

public interface BenefitService {

    void save(String name);
    List<String> findAll();
}
