package pl.pp.spring.newsarticlesapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.pp.spring.newsarticlesapp.model.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
