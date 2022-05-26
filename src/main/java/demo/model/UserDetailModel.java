package demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "standard_user")
@NoArgsConstructor
public class UserDetailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public String firstname;

    public String lastname;

    public String username;

    public UserDetailModel(String firstname, String lastname, String username) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
    }
}
