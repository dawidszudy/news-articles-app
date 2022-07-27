package pl.pp.spring.newsarticlesapp.services;

import org.springframework.stereotype.Service;
import pl.pp.spring.newsarticlesapp.model.Article;
import pl.pp.spring.newsarticlesapp.repositories.ArticleRepository;


import java.util.ArrayList;
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
        //Article article = articleRepository.findById(id).orElse(null);
        articleRepository.deleteById(id);
    }

    @Override
    public Object findByWord(String word) {
//        //szukanie joków dla kategorii i usuwanie relacji między tymi jokami a kategorią
//        Article article = articleRepository.findById(word).orElse(null);
//
//        article.getContent().forEach(joke -> {
//            joke.getCategories().remove(category);
//        });
//
//        return categoryRepository.deleteById(id);
        return null;
    }
}
