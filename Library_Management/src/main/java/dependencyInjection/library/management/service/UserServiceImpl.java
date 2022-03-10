package dependencyInjection.library.management.service;

import dependencyInjection.library.management.dto.Books;
import dependencyInjection.library.management.dto.User;
import dependencyInjection.library.management.dto.UserBookHistory;
import dependencyInjection.library.management.entity.BookEntity;
import dependencyInjection.library.management.entity.UserBookHistoryEntity;
import dependencyInjection.library.management.entity.UserEntity;
import dependencyInjection.library.management.repository.BookRepository;
import dependencyInjection.library.management.repository.UserBookHistoryRepository;
import dependencyInjection.library.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class UserServiceImpl implements UserService,BookService, UserBookHistoryServices {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserBookHistoryRepository userBookHistoryRepository;

    public static <T> T mostCommon(List<T> list) {
        Map<T, Integer> map = new HashMap<>();
        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> max = null;
        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
    }

    @Override
    public void addUser(User user){
        userRepository.save(new UserEntity(user.getId(),user.getName(), user.getAddress(), user.getpNumber()));

    }

    @Override
    public List<User> getAllUsers(){

                Iterable<UserEntity> userEntityList  = userRepository.findAll();
        List<User> UserResponseList = new ArrayList<>();
        for( UserEntity userEntity: userEntityList){
            User user = new User(userEntity.getId(), userEntity.getName(), userEntity.getAddress(), userEntity.getpNumber());
            UserResponseList.add(user);


        }
        return UserResponseList;
    }


    @Override
    public void addBooks(Books book){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(book.getId());
        bookEntity.setName(book.getName());
        bookEntity.setWriter(book.getWriter());
        bookEntity.setSummary(book.getSummary());
        bookEntity.setCategory(book.getCategory());
        bookRepository.save(bookEntity);
    }


    @Override
    public List<Books> getAllBooks(){
        Iterable<BookEntity> bookEntityList  = bookRepository.findAll();
        List<Books> BookResponseList = new ArrayList<>();
        for( BookEntity bookEntity: bookEntityList){
            Books books = new Books(bookEntity.getId(), bookEntity.getName(), bookEntity.getWriter(), bookEntity.getSummary(), bookEntity.getCategory());
            BookResponseList.add(books);


        }
        return BookResponseList;

    }


    @Override
    public List<UserBookHistory> getAllUserBookHistory(){
        Iterable<UserBookHistoryEntity> userBookHistoryEntityList  = userBookHistoryRepository.findAll();
        List<UserBookHistory> HistoryResponseList = new ArrayList<>();
        for( UserBookHistoryEntity userBookHistoryEntity: userBookHistoryEntityList){
            UserBookHistory bookHistory = new UserBookHistory(userBookHistoryEntity.getId(), userBookHistoryEntity.getUser().getId(), userBookHistoryEntity.getBook().getId(), userBookHistoryEntity.getStartdate(), userBookHistoryEntity.getEnddate());
            HistoryResponseList.add(bookHistory);


        }
        return HistoryResponseList;

    }

    @Override
    public void addHistory(UserBookHistory userBookHistory){
        UserBookHistoryEntity userBookHistoryEntity = new UserBookHistoryEntity();

        Optional<UserEntity> byId = userRepository.findById(userBookHistory.getUserid());
        Optional<BookEntity> byId1 = bookRepository.findById(userBookHistory.getBookid());
        if(byId.isPresent() && byId1.isPresent()){

            BookEntity bookEntity = byId1.get();
            userBookHistoryEntity.setBook(bookEntity);



            userBookHistoryEntity.setStartdate(userBookHistory.getStartdate());
            userBookHistoryEntity.setEnddate(userBookHistory.getEnddate());

            UserEntity userEntity = byId.get();
            userBookHistoryEntity.setUser(userEntity);

            userBookHistoryRepository.save(userBookHistoryEntity);

        }


    }




    @Override
    public void returnDate(UserBookHistory userBook){
        for(UserBookHistoryEntity userBookHistory:userBookHistoryRepository.findAll()) {
            if (userBookHistory.getId() == userBook.getId() && StringUtils.isEmpty(userBookHistory.getEnddate())) {
                userBookHistory.setEnddate(userBook.getEnddate());
                userBookHistoryRepository.save(userBookHistory);
            }
        }

        }



    @Override
    public Books getPopularBook() {
        Iterable<UserBookHistoryEntity> iterable = userBookHistoryRepository.findAll();
        List<UserBookHistory> list = new ArrayList<>();
        for (UserBookHistoryEntity i : iterable) {
            list.add(new UserBookHistory(i.getId(), i.getUser().getId(), i.getBook().getId(), i.getStartdate(), i.getEnddate()));
        }
        ArrayList<Integer> bookid = new ArrayList<>();
        for (UserBookHistory i : list) {
            bookid.add(i.getBookid());
        }
        Integer max = mostCommon(bookid);
        Iterable<BookEntity> books = bookRepository.findAll();
        Books books1 = new Books();
        for (BookEntity i : books) {
            if (i.getId() == max) {
                books1.setId(i.getId());
                books1.setName(i.getName());
                books1.setCategory(i.getCategory());
                books1.setSummary(i.getSummary());
                books1.setCategory(i.getCategory());
            }
        }


        return books1;
    }


    @Override
    public User getUserWithMaxBooks() {
        Iterable<UserBookHistoryEntity> iterable = userBookHistoryRepository.findAll();
        List<UserBookHistory> list = new ArrayList<>();
        for (UserBookHistoryEntity i : iterable) {
            list.add(new UserBookHistory(i.getId(), i.getUser().getId() , i.getBook().getId() , i.getStartdate(), i.getEnddate()));
        }
        ArrayList<Integer> userId = new ArrayList<>();
        for (UserBookHistory i : list) {
            userId.add(i.getUserid());
        }

        Integer max = mostCommon(userId);
        Iterable<UserEntity> userEntities = userRepository.findAll();
        User user = new User();
        for (UserEntity i : userEntities) {
            if (i.getId() == max) {
                user.setId(i.getId());
                user.setName(i.getName());
                user.setAddress(i.getAddress());
                user.setpNumber(i.getpNumber());
            }
        }
        return user;
    }


}

