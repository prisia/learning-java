package demo.controller;

import demo.repository.UserRepository;
import demo.model.UserDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<UserDetailModel> getUserData(){
        List<UserDetailModel> userList = new ArrayList<>();

        UserDetailModel user1 = new UserDetailModel();
        user1.setUsername("Hezent");
        user1.setFirstname("Prisia");
        user1.setLastname("Calista");
        userList.add(user1);

        user1 = new UserDetailModel();
        user1.setUsername("Mammooth");
        user1.setFirstname("Chandra");
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

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/user-jpa")
    public List<UserDetailModel> getJpaData(){
        return userRepo.findAll();
    }

    @GetMapping("/user-jpa/{id}")
    public ResponseEntity<UserDetailModel> getUserByUsername(@PathVariable("id") Integer id) {
        Optional<UserDetailModel> userData = userRepo.findById(id);
        return userData.map(userDetailModel -> new ResponseEntity<>(userDetailModel, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/user-jpa")
    public ResponseEntity<UserDetailModel> createUser(@RequestBody UserDetailModel userDTO){
        try {
            List<UserDetailModel> userData = userRepo.findByfirstname(userDTO.getFirstname());
            if(!userData.isEmpty()){
                return  new ResponseEntity<>( HttpStatus.BAD_REQUEST);
            }
            UserDetailModel newUser = userRepo.save(new UserDetailModel(userDTO.getFirstname(), userDTO.getLastname(), userDTO.getUsername()));
            return  new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
