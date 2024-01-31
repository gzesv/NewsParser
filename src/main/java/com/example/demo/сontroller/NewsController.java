package com.example.demo.сontroller;

import com.example.demo.model.Link;
import com.example.demo.model.News;
import com.example.demo.service.PsqlService;
import com.example.demo.parser.Parser;
import com.example.demo.model.Rubric;
import com.example.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class NewsController {
    private final PsqlService psqlService;

    private final NewsService newsService = new NewsService();

    @Autowired
    public NewsController(PsqlService psqlService) {
        this.psqlService = psqlService;
    }

    @GetMapping(value = "/delete")
    public void delete(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        psqlService.deleteNews();
        psqlService.deleteRubric();
    }

    @GetMapping(value = "/filldb")
    public void fill(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) throws SQLException, IOException {
        Parser parser = new Parser();

        List<Rubric> rubrics = parser.getRubrics("https://lenta.ru/");
        psqlService.saveRubric(rubrics);

        rubrics = psqlService.getAllRubric();
        List<News> news = parser.getNews(rubrics);
        psqlService.saveNews(news);
    }

    @GetMapping("/sources")
    public Object sources(@RequestParam(name = "login") String login, Model model) {
        if (!psqlService.isValidUser(login)) {
            return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
        }

        List<Link> links = psqlService.getAllLinks();

        model.addAttribute("link", links);

        return "Link";
    }

    @GetMapping("/rubrics")
    public Object rubrics(
            @RequestParam(name = "login") String login,
            @RequestParam(name = "sourse", required = false, defaultValue = "https://lenta.ru/") String sourse,
            Model model
    ) {
        if (!psqlService.isValidUser(login)) {
            return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
        }

        List<Rubric> rubrics;

        try {
            rubrics = newsService.getRubricsByLink(sourse);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("rubric", rubrics);

        return "Rubric";
    }

    @GetMapping("/news")
    public Object news(
            @RequestParam(name = "login") String login,
            @RequestParam(name = "sourse", required = false) String sourse,
            @RequestParam(name = "rubric", required = false) String rubric,
            @RequestParam(name = "date", required = false) String date,
            Model model
    ) {
        if (!psqlService.isValidUser(login)) {
            return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
        }

        List<News> news;

        try {
            news = newsService.getNewsByParams(sourse, rubric, date);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("news", news);

        return "News";
    }
}
