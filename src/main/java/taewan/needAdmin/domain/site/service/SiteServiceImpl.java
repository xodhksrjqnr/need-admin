package taewan.needAdmin.domain.site.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.needAdmin.domain.site.dto.SiteInfoDto;
import taewan.needAdmin.domain.site.entity.Site;
import taewan.needAdmin.domain.site.repository.SiteRepository;
import taewan.needAdmin.global.utils.AutoUpload;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SiteServiceImpl implements SiteService {

    private final SiteRepository siteRepository;
    private final AutoUpload autoUpload;


    @Override
    public List<SiteInfoDto> findAll() {
         return siteRepository.findAll().stream().map(Site::toInfoDto).toList();
    }

    @Override
    public void autoUploadPosts() {

    }
}
