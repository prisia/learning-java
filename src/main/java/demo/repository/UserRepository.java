package demo.repository;

import demo.model.UserDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserDetailModel, Integer> {
    List<UserDetailModel> findByfirstname(String firstname);

}