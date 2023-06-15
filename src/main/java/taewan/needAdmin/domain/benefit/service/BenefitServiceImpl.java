package taewan.needAdmin.domain.benefit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.needAdmin.domain.benefit.entity.Benefit;
import taewan.needAdmin.domain.benefit.repository.BenefitRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BenefitServiceImpl implements BenefitService {

    private final BenefitRepository benefitRepository;

    @Transactional(readOnly = false)
    @Override
    public void save(String name) {
        if (benefitRepository.findByName(name).isEmpty()) {
            benefitRepository.save(new Benefit(name));
        }
    }

    @Override
    public List<String> findAll() {
        return benefitRepository.findAll()
                .stream().map(Benefit::getName)
                .toList();
    }
}
