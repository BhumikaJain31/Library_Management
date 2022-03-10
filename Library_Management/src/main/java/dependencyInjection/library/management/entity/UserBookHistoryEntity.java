package dependencyInjection.library.management.entity;



import javax.persistence.*;

@Entity
@Table(name = "userBookHistory")
public class UserBookHistoryEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String startdate;
    private String enddate;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    UserEntity user;

    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    BookEntity book;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }


    //    public UserEntity getUserid() {
//        return user;
//    }
//
//    public void setUserid(UserEntity userid) {
//        this.user = user;
//    }
//
//    public BookEntity getBookid() {
//        return book;
//    }
//
//    public void setBookid(BookEntity bookid) {
//        this.book = book;
//    }

//    public String getStartdate() {
//        return startdate;
//    }
//
//    public void setStartdate(String startdate) {
//        this.startdate = startdate;
//    }


    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

//    public UserBookHistoryEntity(Integer id, String startdate, String enddate, UserEntity user, BookEntity book) {
//        this.id = id;
//        this.startdate = startdate;
//        this.enddate = enddate;
//        this.user = user;
//        this.book = book;
//    }


        public UserBookHistoryEntity(Integer id, Integer userid, Integer bookid, String startdate, String enddate){
        this.id = id;
        this.user.id = userid;
        this.book.id = bookid;
        this.startdate = startdate;
        this.enddate = enddate;

    }

    public UserBookHistoryEntity(){

    }
}
