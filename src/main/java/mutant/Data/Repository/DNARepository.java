package mutant.Data.Repository;

import mutant.Data.Model.DNA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface DNARepository extends CrudRepository<DNA,Long>, DNACustomRepository {
}
