package books;

import books.Book;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vasco Ramos
 * @date 19/03/20
 * @time 13:02
 */

public class Library {
    private final List<Book> store = new ArrayList<>();

    public void addBook(final Book book) {
        this.store.add(book);
    }

    public List<Book> findBooks(final LocalDateTime from, final LocalDateTime to) {

        return store.stream().filter(book -> {
            return from.isBefore(book.getPublished()) && to.isAfter(book.getPublished());
        }).sorted(Comparator.comparing(Book::getPublished).reversed()).collect(Collectors.toList());
    }
}