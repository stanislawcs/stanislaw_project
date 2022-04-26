package by.stanislaw.it.repository;

import by.stanislaw.it.entity.SecurityGuard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface GuardRepository extends JpaRepository<SecurityGuard, String> {
    @Query("from SecurityGuard where passportNumber =:passportNumber")
    Optional<SecurityGuard> findSecurityGuardByPassportNumber(@Param("passportNumber") String passportNumber);

    @Query("from SecurityGuard where name =:name")
    Optional<SecurityGuard> findSecurityGuardByName(@Param("name") String name);

    @Query("update SecurityGuard set pathToGuardImage=:path where id=:id")
    @Modifying
    void updatePathToGuardImageById(@Param("path") String path,@Param("id") String id);

    @Query("from SecurityGuard where upper(name) like %:inputText%")
    List<SecurityGuard> searchSecurityGuardNameByInputText(@Param("inputText") String inputText);

}


