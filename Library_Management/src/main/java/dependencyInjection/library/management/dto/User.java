package dependencyInjection.library.management.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class User implements Serializable {

    private Integer id;
    private String name;
    private String address;
    private Long pNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getpNumber() {
        return pNumber;
    }

    public void setpNumber(Long pNumber) {
        this.pNumber = pNumber;
    }



    public User(Integer id, String name, String address, Long pNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.pNumber = pNumber;
    }


    public User(){

    }
}