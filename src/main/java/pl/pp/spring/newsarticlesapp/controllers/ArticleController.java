package pl.pp.spring.newsarticlesapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pp.spring.newsarticlesapp.model.Article;
import pl.pp.spring.newsarticlesapp.services.ArticleService;


@Controller
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/saveArticle")
    public String showAddForm(Model model) {
        model.addAttribute("article", new Article());
        return "saveArticle";
    }

    @GetMapping("/articles/{articleId}/edit")
    public String showEditCategoryForm(@PathVariable Long articleId, Model model) {
        Article article = (Article) articleService.findById(articleId);
        model.addAttribute("article", article);
        return "saveArticle";
    }

    @PostMapping("/saveArticle")
    public String saveTraining(@ModelAttribute Article article) {
        articleService.save(article);
        return "redirect:/articlesList";
    }

    @GetMapping("/articles/{articleId}/delete")
    public String deleteTraining(@PathVariable Long articleId) {
        articleService.deleteById(articleId);
        return "redirect:/articlesList";
    }


    @GetMapping("/articlesList")
    public String showList(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "articlesList";
    }


}
