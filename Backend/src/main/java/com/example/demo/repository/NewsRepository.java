package com.example.demo.repository;

import com.example.demo.model.News;
import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends CrudRepository<News,Integer> {
    News findByCaption(String caption);
    List<News> findByUser(User user);
}
