package taewan.needAdmin.global.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import taewan.needAdmin.domain.site.entity.Site;
import taewan.needAdmin.global.vo.CrawlingVo;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crawling {

    private static final ThreadLocal<Map<String, String>> foundPosts = new ThreadLocal<>();
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String[] filterKeyWords = {"신청", "지원"};

    public CrawlingVo getNewPosts(Site site) {
        foundPosts.set(new HashMap<>());
        driver.set(new ChromeDriver());
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get().get(site.getUrl());

        String firstPost = driver.get()
                .findElement(By.className(site.getPostsTag()))
                .findElement(By.className("item"))
                .findElement(By.className(site.getSubjectTag()))
                .getText();

        crawlingPage(site);

        CrawlingVo data = new CrawlingVo(firstPost, foundPosts.get());

        driver.get().quit();
        driver.remove();
        foundPosts.remove();
        return data;
    }

    private static void crawlingPage(Site site) {
        boolean foundFlag = true;
        int prePage = 0;

        while (foundFlag) {
            foundFlag = false;

            List<WebElement> pages = driver.get()
                    .findElement(By.className(site.getPageListTag()))
                    .findElements(By.tagName("li"));

            while (true) {
                String cur = pages.get(0).getText().replaceAll("[^0-9]", "");

                if (!cur.equals("")) break;
                pages.remove(0);
            }

            for (WebElement page : pages) {
                String click = page.getText().replaceAll("[^0-9]", "");

                if (!click.equals("") && prePage >= Integer.parseInt(click)) continue;

                page.click();

                if (click.equals("")) {
                    foundFlag = true;
                    break;
                }

                prePage++;

                List<WebElement> posts = driver.get()
                        .findElement(By.className(site.getPostsTag()))
                        .findElements(By.className("item"));

                for (WebElement post : posts) {
                    String curPost = post.findElement(By.className(site.getSubjectTag())).getText();

                    if (curPost.equals(site.getRecentPostTag())) {
                        return;
                    }

                    foundFlag = true;

                    if (isNotContainKeyWord(curPost)) continue;

                    String curUrl = post.findElement(By.tagName("a")).getAttribute("href");

                    if (!foundPosts.get().containsKey(curPost)) {
                        foundPosts.get().put(curPost, curUrl);
                    }
                }
                break;
            }
        }
    }

    private static boolean isNotContainKeyWord(final String str) {
        for (String word : filterKeyWords) {
            if (str.contains(word))
                return false;
        }
        return true;
    }
}
