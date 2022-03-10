package dependencyInjection.library.management.entity;


import javax.persistence.*;

@Entity
@Table(name = "Users")
public class UserEntity {
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


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Integer id;
   private String name;
   private String address;
   private Long pNumber;

   public UserEntity(Integer id, String name, String address, Long pNumber) {
      this.id = id;
      this.name = name;
      this.address = address;
      this.pNumber = pNumber;
   }


   public UserEntity(){

   }
}
