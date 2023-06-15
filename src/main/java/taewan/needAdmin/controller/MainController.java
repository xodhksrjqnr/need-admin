package taewan.needAdmin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import taewan.needAdmin.domain.post.dto.PostUploadForm;
import taewan.needAdmin.domain.post.service.PostService;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final PostService postService;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("posts", postService.findAllWithSortedDESC());
        return "index";
    }

    @GetMapping("/uploadForm")
    public String uploadFormPage(Model model, PostUploadForm form) {
        model.addAttribute("form", form);
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String uploadPost(PostUploadForm form) {
        postService.upload(form);
        return "redirect:/";
    }
}
