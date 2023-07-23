package taewan.needAdmin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import taewan.needAdmin.global.utils.Scraping;

@SpringBootTest
public class ScrapingTest {

    @Test
    @DisplayName("스크래핑 테스트")
    void test() {
        Scraping scraping = new Scraping();

        scraping.scraping("https://news.seoul.go.kr/welfare/archives/554094", "post_content");
    }
}
