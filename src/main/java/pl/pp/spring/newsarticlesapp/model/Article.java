package pl.pp.spring.newsarticlesapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateArticle;

    private String magazineName;
    private String authorFirstName;
    private String authorLastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfSave = LocalDate.now();

    public Article() {
    }

    public Article(String title, String content, LocalDate dateArticle,
                   String magazineName, String authorFirstName, String authorLastName, LocalDate dateOfSave) {
        this.title = title;
        this.content = content;
        this.dateArticle = dateArticle;
        this.magazineName = magazineName;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.dateOfSave = dateOfSave;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDateArticle() {
        return dateArticle;
    }

    public void setDateArticle(LocalDate dateArticle) {
        this.dateArticle = dateArticle;
    }

    public LocalDate getDateOfSave() {
        return dateOfSave;
    }

    public void setDateOfSave(LocalDate dateOfSave) {
        this.dateOfSave = dateOfSave;
    }

    public String getMagazineName() {
        return magazineName;
    }

    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dateArticle=" + dateArticle +
                ", magazineName='" + magazineName + '\'' +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", dateArticleOfSave=" + dateOfSave +
                '}';
    }
}

