package taewan.needAdmin.domain.benefit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.needAdmin.domain.benefit.entity.Benefit;

import java.util.Optional;

public interface BenefitRepository extends JpaRepository<Benefit, Long> {

    Optional<Benefit> findByName(String name);
}
