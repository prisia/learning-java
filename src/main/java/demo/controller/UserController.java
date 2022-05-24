package demo.controller;

import demo.model.UserDetailModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<UserDetailModel> getUserData(){
        List<UserDetailModel> userList = new ArrayList<>();

        UserDetailModel user1 = new UserDetailModel();
        user1.setFirstName("Prisia");
        user1.setLastname("Calista");
        userList.add(user1);
        return userList;
    };
}
