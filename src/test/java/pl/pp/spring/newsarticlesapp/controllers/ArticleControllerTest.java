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

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ArticleControllerTest {

    @Mock
    private ArticleService articleService;

    @InjectMocks
    private ArticleController articleController;

    private MockMvc mockMvc;

    private Article article = new Article();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(articleController)
                .build();
    }

    @Test
    void showAddForm() {
    }

    @Test
    void showEditCategoryForm() {
    }

    @Test
    void saveTraining() {
    }

    @Test
    void deleteTraining() {
    }

    @Test
    void showList() throws Exception {
        List<Article> listArticles = new ArrayList<>();
        Article article1 = new Article();
        Article article2 = new Article();

        listArticles.add(article1);
        listArticles.add(article2);

        when(articleService.findAll()).thenReturn(listArticles);

        mockMvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(view().name("articlesList"))
                .andExpect(model().attribute("articles", hasSize(2)));

        verify(articleService).findAll();
    }
}
