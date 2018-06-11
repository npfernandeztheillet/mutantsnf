package mutant.Repository;

import mutant.Model.DNA;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Transactional
public class DNARepositoryImpl implements DNACustomRepository {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public int findByDNA(String dna) {
        javax.persistence.Query query = this.entityManager.createNativeQuery("select max(d.id) from dna d where d.dna=?1");
        query.setParameter(1, dna);
        List results = query.getResultList();
        if (results.size()>0){
            Object result= results.get(0);
            if (result!=null)
                return (int)result;
        }
        return 0;
    }

    public  <S extends DNA> S save(S entity)throws Exception{
        int existingId= this.findByDNA(entity.getDNA());
        if (existingId==0) {
            this.entityManager.persist(entity);
            this.entityManager.flush();
            return entity;
        }
        throw new Exception("The entity does exists.");
    }

}
