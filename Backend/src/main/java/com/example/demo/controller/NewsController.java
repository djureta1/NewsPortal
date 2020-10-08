package com.example.demo.controller;

import com.example.demo.dto.NewsDTO;
import com.example.demo.model.News;
import com.example.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class NewsController {

    @Autowired
    NewsService newsService;

    @PostMapping("/news")
    @ResponseStatus(HttpStatus.CREATED)
    News addNews(@RequestBody NewsDTO newsDTO) {
        return newsService.addNews(newsDTO);
    }

    @PutMapping("/news/{id}")
    News editNews(@PathVariable Integer id, @RequestBody NewsDTO newsDTO){return newsService.editNews(id,newsDTO); }
    @DeleteMapping("/news/{id}")
    void deleteNews(@PathVariable Integer id) throws Exception {
        newsService.deleteNewsById(id);
    }

    @GetMapping("/news/all")
    List<News> allNews() throws Exception {
        return newsService.getAllNews();
    }
}

