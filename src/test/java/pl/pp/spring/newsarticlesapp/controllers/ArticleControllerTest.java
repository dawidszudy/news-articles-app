package pl.pp.spring.newsarticlesapp.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.pp.spring.newsarticlesapp.model.Article;
import pl.pp.spring.newsarticlesapp.services.ArticleService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ArticleControllerTest {

    @Mock
    private ArticleService articleService;

    @InjectMocks
    private ArticleController articleController;

    private MockMvc mockMvc;

    private Article article = new Article();
    private Long id = Long.valueOf(2);

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(articleController)
                .build();
    }

    @Test
    void showAddForm() throws Exception {
        mockMvc.perform(get("/saveArticle"))
                .andExpect(status().isOk())
                .andExpect(view().name("articles/save"));
    }

    @Test
    void showEditCategoryForm() throws Exception {
        when(articleService.findById(anyLong())).thenReturn(id);

        mockMvc.perform(get("/articles/2/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("article"))
                .andExpect(view().name("articles/save"));

        verify(articleService).findById(2L);
    }

    @Test
    void saveTraining() throws Exception {
        mockMvc.perform(post("/articles/save"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/articlesList"));

        verify(articleService).save(any(Article.class));
    }

    @Test
    void deleteExistTraining() throws Exception {
        mockMvc.perform(get("/articles/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/articlesList"));

        verify(articleService).deleteById(1L);
    }

    @Test
    void showList() throws Exception {
        List<Article> listArticles = new ArrayList<>();
        Article article1 = new Article();
        Article article2 = new Article();

        listArticles.add(article1);
        listArticles.add(article2);

        when(articleService.findAll()).thenReturn(listArticles);

        mockMvc.perform(get("/articlesList"))
                .andExpect(status().isOk())
                .andExpect(view().name("articles/list"))
                .andExpect(model().attribute("articles", hasSize(2)));

        verify(articleService).findAll();
    }
}
