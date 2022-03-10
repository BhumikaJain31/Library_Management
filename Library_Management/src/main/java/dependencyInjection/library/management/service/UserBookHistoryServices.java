package dependencyInjection.library.management.service;

import dependencyInjection.library.management.dto.Books;
import dependencyInjection.library.management.dto.User;
import dependencyInjection.library.management.dto.UserBookHistory;

import java.util.List;

public interface UserBookHistoryServices {
    List<UserBookHistory> getAllUserBookHistory();
    void addHistory(UserBookHistory userBookHistory);
    void returnDate(UserBookHistory userBookHistory);
    Books getPopularBook();
    User getUserWithMaxBooks();
}
