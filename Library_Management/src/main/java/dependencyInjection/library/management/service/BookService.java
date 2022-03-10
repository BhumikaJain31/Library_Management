package dependencyInjection.library.management.service;

import dependencyInjection.library.management.dto.Books;

import java.util.List;

public interface BookService {
    List<Books> getAllBooks();
    void addBooks(Books user);

}
