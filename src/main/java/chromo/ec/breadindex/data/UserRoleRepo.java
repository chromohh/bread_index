package chromo.ec.breadindex.data;

import chromo.ec.breadindex.entity.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends CrudRepository<UserRole, Integer> {
}
