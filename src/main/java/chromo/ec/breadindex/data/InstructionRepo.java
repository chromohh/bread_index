package chromo.ec.breadindex.data;

import chromo.ec.breadindex.entity.Instruction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionRepo extends CrudRepository<Instruction, Integer> {
}
