package pl.pp.spring.newsarticlesapp.services;

import pl.pp.spring.newsarticlesapp.model.Article;

import java.util.List;

public interface ArticleService<E> {

    List<E> findAll();

    E findById(Long id);

    Article save(Article article);

    void deleteById(Long Id);

    E findByWord(String word);
}
