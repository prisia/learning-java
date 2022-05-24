package demo.controller;

import demo.model.UserDetailModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<UserDetailModel> getUserData(){
        List<UserDetailModel> userList = new ArrayList<>();

        UserDetailModel user1 = new UserDetailModel();
        user1.setUserName("Hezent");
        user1.setFirstName("Prisia");
        user1.setLastname("Calista");
        userList.add(user1);

        user1 = new UserDetailModel();
        user1.setUserName("Mammooth");
        user1.setFirstName("Chandra");
        user1.setLastname("Liaow");
        userList.add(user1);
        return userList;
    };

    @GetMapping("/user/{userName}")
    public UserDetailModel getUser(@PathVariable("userName") String userName){
        UserDetailModel user = new UserDetailModel();
        System.out.println("Username =>" + userName);


        return user;
    }
}
