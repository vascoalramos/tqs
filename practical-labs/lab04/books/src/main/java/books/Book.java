package books;

import java.time.LocalDateTime;

/**
 * @author Vasco Ramos
 * @date 19/03/20
 * @time 13:01
 */

public class Book {
    private final String title;
    private final String author;
    private final LocalDateTime published;

    public Book(final String title, final String author, final LocalDateTime published) {
        this.title = title;
        this.author = author;
        this.published = published;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public LocalDateTime getPublished() {
        return this.published;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", published=" + published + "]";
    }
}