package pl.pp.spring.newsarticlesapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.pp.spring.newsarticlesapp.model.Article;
import pl.pp.spring.newsarticlesapp.services.ArticleDbService;

import java.time.LocalDate;
import java.time.Month;

@Component
public class DataLoader implements CommandLineRunner {

    private final ArticleDbService articleDbService;

    public DataLoader(ArticleDbService articleDbService) {
        this.articleDbService = articleDbService;
    }

    @Override
    public void run(String... args) {

        Article article1 = getExampleArticle1();
        Article article2 = getExampleArticle2();

        articleDbService.save(article1);
        articleDbService.save(article2);

        System.out.println("Data Loader");
    }

    private Article getExampleArticle1() {
        Article article1 = new Article();

        article1.setTitle("Federal Reserve");
        article1.setContent("As the Federal Reserve has lifted its key interest rate, " +
                "Americans have seen the effects on both sides of the household ledger: Savers");
        article1.setDateArticle(LocalDate.of(2022, Month.MAY, 11));
        article1.setMagazineName("Times");
        article1.setAuthorFirstName("Thomas");
        article1.setAuthorLastName("Brown");

        return article1;
    }

    private Article getExampleArticle2() {
        Article article2 = new Article();

        article2.setTitle("Caribbean");
        article2.setContent("The Caribbean is trapped between crushing debt and a climate disaster caused by rich nations. " +
                "Prime Minister Mia Mottley is battling for a fairer system." +
                "By ABRAHM LUSTGARTEN");
        article2.setDateArticle(LocalDate.of(2022, Month.JUNE, 19));
        article2.setMagazineName("Times");
        article2.setAuthorFirstName("Peter");
        article2.setAuthorLastName("Smith");

        return article2;
    }

}
