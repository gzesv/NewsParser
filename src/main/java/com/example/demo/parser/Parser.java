package com.example.demo.parser;

import com.example.demo.repository.DatabaseHandler;
import com.example.demo.model.News;
import com.example.demo.model.Rubric;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final DatabaseHandler databaseHandler = new DatabaseHandler();

    public Document getHtmlDocument(String url) throws IOException {
        return Jsoup.connect(url)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();
    }

    private Elements getElementsFromDocument(String url, String className) throws IOException {
        Document document = getHtmlDocument(url);
        return document.getElementsByClass(className);
    }

    public List<Rubric> getRubrics(String url) throws IOException, SQLException {
        Elements elements = getElementsFromDocument(url,
                "menu__nav-link _is-extra");

        ResultSet link = databaseHandler.selectLinkId(url);

        Integer linkID = link.next() ? link.getInt(1) : -1;

        List<Rubric> rubrics = new ArrayList<>();

        for (Element el : elements) {
            rubrics.add(new Rubric(
                    el.text(),
                    el.attributes().get("href"),
                    linkID.hashCode()
            ));
        }

        return rubrics;
    }

    public List<News> getNews(List<Rubric> rubrics) throws IOException {
        List<News> news = new ArrayList<>();

        for (Rubric rubric : rubrics) {
            Document document = getHtmlDocument("https://lenta.ru/" + rubric.getRubricHref());

            Elements newsName = document.getElementsByClass("card-mini__title");
            Elements newsDate = document.getElementsByClass("card-mini__info-item").removeAttr("svg");
            int min = Math.min(newsName.size(), newsDate.size());
            for (int j = 0; j < min; j++) {
                news.add(new News(
                        newsName.get(j).text(),
                        newsDate.get(j).hasText() ? newsDate.get(j).text(): "",
                        rubric.getId()
                ));
            }
        }
        return news;
    }
}
