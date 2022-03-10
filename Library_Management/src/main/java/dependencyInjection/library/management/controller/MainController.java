//package dependencyInjection.library.management.controller;
//
//public class MainController {
//}
package dependencyInjection.library.management.controller;

import dependencyInjection.library.management.dto.Books;
import dependencyInjection.library.management.dto.User;
import dependencyInjection.library.management.dto.UserBookHistory;
import dependencyInjection.library.management.service.BookService;
import dependencyInjection.library.management.service.UserBookHistoryServices;
import dependencyInjection.library.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("control")
@Controller
public class MainController {


    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    UserBookHistoryServices userBookHistoryServices;

    @GetMapping("/users")
    public List<User> getUser(){
        return userService.getAllUsers();
    }



    @PostMapping(value = "User")
    public void addUser(
            @RequestBody @Valid User user
    ){

        userService.addUser(user);
    }


    @GetMapping("/books")
    public List<Books> getBooks(){
        return bookService.getAllBooks();
    }



    @PostMapping("/book1")
    public void addBooks(@RequestBody Books books)
    {

        bookService.addBooks(books);
    }

    @GetMapping("/history")
    public List<UserBookHistory> getUserBook() {return userBookHistoryServices.getAllUserBookHistory();}


    @PostMapping("/history1")
    public void addUserBook(@RequestBody UserBookHistory userBookHistory){
        userBookHistoryServices.addHistory(userBookHistory);
    }

    @PutMapping
    public void returnDate(@RequestBody @Valid UserBookHistory userBookHistory){

        userBookHistoryServices.returnDate(userBookHistory);
    }

    @GetMapping("/popularbook")
    public Books getPopularBook(){
        return userBookHistoryServices.getPopularBook();
    }

    @GetMapping("/userwithmaxbooks")
    public User getuserwithmaxbooks(){
        return userBookHistoryServices.getUserWithMaxBooks();
    }


}

