package taewan.needAdmin.domain.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.needAdmin.domain.site.entity.Site;

public interface SiteRepository extends JpaRepository<Site, Integer> {
}
