package by.stanislaw.it.repository;

import by.stanislaw.it.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface UserRepository extends JpaRepository<User,String> {

    @Query("from User where username=:username")
    Optional<User>findUserByUsername(@Param("username") String username);

    @Query("update User set pathToImage =:path where id=:id")
    @Modifying
    void updateUserPathToImageById(@Param("path")String path,@Param("id") String id);


}
