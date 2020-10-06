package com.example.demo.service;

import com.example.demo.dto.NewsDTO;
import com.example.demo.model.News;
import com.example.demo.model.User;
import com.example.demo.repository.NewsRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;
    @Autowired
    UserRepository userRepository;

    public List<News> getAllNews() throws Exception{
        if(newsRepository.count()==0) {
            throw new Exception("The base is empty.");
        }
        List<News> allNews=new ArrayList<>();
        newsRepository.findAll().forEach(allNews::add);
        return allNews;
    }

    public News addNews(NewsDTO newsDTO){
        User user=userRepository.findById(newsDTO.getUserId()).get();
        News news=new News(newsDTO.getCaption(),newsDTO.getText(),user,newsDTO.getDate());
        return newsRepository.save(news);
    }

    public News editNews(Integer id, NewsDTO newsDTO){
        News news=newsRepository.findById(id).get();
        news.setCaption(newsDTO.getCaption());
        news.setText(newsDTO.getText());

        return newsRepository.save(news);
    }

    public void deleteNewsById(Integer id) throws Exception{
        if(!newsRepository.existsById(id)){
            throw new Exception("News with ID "+id+" do not exist");
        }
        newsRepository.deleteById(id);
    }
}
