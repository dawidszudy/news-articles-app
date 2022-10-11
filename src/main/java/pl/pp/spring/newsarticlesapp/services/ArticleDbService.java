package pl.pp.spring.newsarticlesapp.services;

import org.springframework.stereotype.Service;
import pl.pp.spring.newsarticlesapp.model.Article;
import pl.pp.spring.newsarticlesapp.repositories.ArticleRepository;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ArticleDbService implements ArticleService{

    private final ArticleRepository articleRepository;

    public ArticleDbService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @Override
    public List<Article> findAll() {
        List<Article> articles = new ArrayList<>();
        articleRepository.findAll().forEach(articles::add);
        Collections.sort(articles, (a, b)->b.getDateArticle().compareTo(a.getDateArticle()));
        return articles;
    }

    @Override
    public Article findById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Article findByWord(String word) {
        return null;
    }
}
