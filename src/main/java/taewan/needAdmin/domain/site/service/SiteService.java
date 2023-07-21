package taewan.needAdmin.domain.site.service;

import taewan.needAdmin.domain.site.dto.SiteInfoDto;

import java.util.List;

public interface SiteService {

    List<SiteInfoDto> findAll();
    void autoUploadPosts();
}
