package com.example.demo.service;

import com.example.demo.model.Link;
import com.example.demo.model.News;
import com.example.demo.model.Rubric;
import com.example.demo.repository.LinkRepository;
import com.example.demo.repository.NewsRepository;
import com.example.demo.repository.RubricRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsqlService {
    private final RubricRepository rubricRepository;
    private final NewsRepository newsRepository;
    private final UserRepository userRepository;
    private final LinkRepository linkRepository;

    @Autowired
    public PsqlService(
            RubricRepository rubricRepository,
            NewsRepository newsRepository,
            UserRepository userRepository,
            LinkRepository linkRepository
    ) {
        this.rubricRepository = rubricRepository;
        this.newsRepository = newsRepository;
        this.userRepository = userRepository;
        this.linkRepository = linkRepository;
    }

    public List<Link> getAllLinks() {
        return linkRepository.findAll();
    }

    public void saveRubric(List<Rubric> rubrics) {
        rubricRepository.saveAll(rubrics);
    }

    public List<Rubric> getAllRubric() {
        return rubricRepository.findAll();
    }


    public void saveNews(List<News> news) {
        newsRepository.saveAll(news);
    }

    public boolean isValidUser(String id) {
        return userRepository.findById(Integer.parseInt(id)).isPresent();
    }

    public void deleteRubric() {
        rubricRepository.deleteAll();
    }

    public void deleteNews() {
        newsRepository.deleteAll();
    }

}