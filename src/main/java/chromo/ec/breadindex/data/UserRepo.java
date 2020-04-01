package chromo.ec.breadindex.data;

import chromo.ec.breadindex.entity.Bread;
import chromo.ec.breadindex.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.userName LIKE %:userName%")
    List<Bread> findByUserName(@Param("userName") String Name);

    @Query("SELECT u FROM User u WHERE u.email LIKE %:email%")
    List<Bread> findByEmail(@Param("email") String email);

}
