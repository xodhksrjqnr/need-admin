package taewan.needAdmin.domain.post.service;

import taewan.needAdmin.domain.post.dto.PostSimpleInfoDto;
import taewan.needAdmin.domain.post.dto.PostUploadForm;

import java.util.List;

public interface PostService {

    List<PostSimpleInfoDto> findAllWithSortedDESC();
    void upload(PostUploadForm form);
    void activeChange(Long postId);
}
