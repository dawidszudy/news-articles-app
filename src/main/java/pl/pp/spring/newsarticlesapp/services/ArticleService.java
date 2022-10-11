package pl.pp.spring.newsarticlesapp.services;

import pl.pp.spring.newsarticlesapp.model.Article;

import java.util.List;

public interface ArticleService {

    List<Article> findAll();

    Article findById(Long id);

    Article save(Article article);

    void deleteById(Long Id);

    Article findByWord(String word);
}
