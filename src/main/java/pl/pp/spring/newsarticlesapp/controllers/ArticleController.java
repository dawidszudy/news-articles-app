package pl.pp.spring.newsarticlesapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pp.spring.newsarticlesapp.model.Article;
import pl.pp.spring.newsarticlesapp.services.ArticleService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Controller
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/saveArticle")
    public String showAddForm(Model model) {
        model.addAttribute("article", new Article());
        return "articles/save";
    }

    @GetMapping("/articles/{articleId}/edit")
    public String showEditArticleForm(@PathVariable Long articleId, Model model) {
        Article article = (Article) articleService.findById(articleId);
        model.addAttribute("article", article);
        return "articles/save";
    }

    @PostMapping("/articles/save")
    public String saveArticle(@ModelAttribute Article article) {
        articleService.save(article);
        return "redirect:/articlesList";
    }

    @GetMapping("/articles/{articleId}/delete")
    public String deleteArticle(@PathVariable Long articleId) {
        articleService.deleteById(articleId);
        return "redirect:/articlesList";
    }


    @GetMapping("/articlesList")
    public String showList(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "articles/list";
    }

    @GetMapping({"/articles"})
    public String showArticleForId(Model model, @RequestParam("articleId") Long articleId) {

        Article article = (Article) articleService.findById(articleId);
        Set<Article> articles = article == null ? new HashSet<>() : Collections.singleton(article);
        model.addAttribute("article", articles);
        model.addAttribute("articles", articleService.findAll());
        return "redirect:/articlesList";
    }


}
