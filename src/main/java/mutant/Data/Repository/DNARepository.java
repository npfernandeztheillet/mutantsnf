package mutant.Data.Repository;

import mutant.Data.Model.DNA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Interface for DNA repository (standard implementation to use with JPA and Ioc).
 */
@Transactional
public interface DNARepository extends CrudRepository<DNA,Long>, DNACustomRepository {
}
