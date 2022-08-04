# News Articles App

## General Information
The small app, which allows user to save articles.

## Technologies Used
- Java
- Spring
- JUnit
- Hibernate
- H2
- HTML
- CSS

## Usage
Run main method in NewsArticlesAppApplication class and enter "localhost:8080" to browser window.

## Endpoints

### showIndex
- Request, URL: "", /, /index
- Parameter: none

### showAddForm
- GET, URL: /saveArticle
- Parameter: Model

### showEditArticleForm
- GET, URL: /articles/{articleId}/edit
- Parameter: Long, Model
- articleId is Long and have taken a number for the existing article id. If you enter the wrong number it will give http:500
articleId have not take null.

### saveArticle
- POST, URL: /articles/save
- Parameter: Article

- Article is an Object with fields: id, title, content, dateArticle, magazineName, authorFirstName, authorLastName, dateOfSave.
- id is Long and have taken a number
- title, content, magazineName, authorFirstName, authorLastName are String but can take numbers or null
- dateArticle and dateOfSave are LocalDate and have taken Date and can't accept null.

### deleteArticle
- GET, URL: /articles/{articleId}/delete
- Parameter: Long

- articleId is Long and have taken a number for the existing article id. If you enter the wrong number it will give http 500
articleId have not take null.

### showList
- GET, URL: /articlesList
- Parameter: Model

### showArticleForId
- GET, URL: /articles
- Parameter: Model, Long