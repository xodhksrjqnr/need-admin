package taewan.needAdmin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import taewan.needAdmin.domain.post.service.PostService;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final PostService postService;

    @PostMapping("/posts/activeChange")
    public void changePostActive(Long postId) {
        postService.activeChange(postId);
    }
}
