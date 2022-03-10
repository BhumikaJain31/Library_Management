package dependencyInjection.library.management.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UserBookHistory implements Serializable {



    private Integer userid;

    private Integer bookid;
    private String startdate;
    private String enddate;

    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

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

    public UserBookHistory(Integer id, Integer userid, Integer bookid, String startdate, String enddate){
        this.id = id;
        this.userid = userid;
        this.bookid = bookid;
        this.startdate = startdate;
        this.enddate = enddate;

    }

    public UserBookHistory(){

    }
}
