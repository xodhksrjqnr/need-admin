package taewan.needAdmin.global.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import taewan.needAdmin.domain.post.entity.Post;

import java.time.Duration;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scraping {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Pattern pattern = Pattern.compile("(지원 *내용?)|((지원|신청) *대상?)|(신청 *기간?)");

    public Optional<Post> scraping(String url, String postViewTag) {
        driver.set(new ChromeDriver());
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get().get(url);

        String view = driver.get().findElement(By.id(postViewTag)).getText();

        driver.get().quit();
        driver.remove();

        return isValidPost(view) ? Optional.of(toPostForm(view)) : Optional.empty();
    }

    private static boolean isValidPost(String view) {
        return pattern.matcher(view).find();
    }

    private static Post toPostForm(String view) {
        Matcher matcher = pattern.matcher(view);

        
        return Post.builder().build();
    }
}
