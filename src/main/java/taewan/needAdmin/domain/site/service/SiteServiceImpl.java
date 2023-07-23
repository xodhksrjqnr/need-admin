package taewan.needAdmin.domain.site.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.needAdmin.domain.post.entity.Post;
import taewan.needAdmin.domain.post.repository.PostRepository;
import taewan.needAdmin.domain.site.dto.SiteInfoDto;
import taewan.needAdmin.domain.site.entity.Site;
import taewan.needAdmin.domain.site.repository.SiteRepository;
import taewan.needAdmin.global.utils.Crawling;
import taewan.needAdmin.global.utils.Scraping;
import taewan.needAdmin.global.vo.CrawlingVo;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SiteServiceImpl implements SiteService {

    private final SiteRepository siteRepository;
    private final PostRepository postRepository;
    private final Crawling crawling = new Crawling();
    private final Scraping scraping = new Scraping();


    @Override
    public List<SiteInfoDto> findAll() {
         return siteRepository.findAll().stream().map(Site::toInfoDto).toList();
    }

    @Override
    @Transactional
    public void autoUploadPosts() {
        siteRepository.findAll().forEach(site -> {
            CrawlingVo newPosts = crawling.getNewPosts(site);
            Map<String, String> posts = newPosts.getPosts();
            List<Post> validPost = new LinkedList<>();

            for (String postName : posts.keySet()) {
                scraping.scraping(posts.get(postName), site.getPostViewTag())
                        .ifPresent(validPost::add);
            }
            if (validPost.size() != 0)
                postRepository.saveAll(validPost);
        });
    }
}
