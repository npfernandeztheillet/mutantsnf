package mutant.Data.Repository;

import mutant.Business.DTOs.DNADTO;
import mutant.Data.Model.DNA;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Transactional
public class DNARepositoryImpl implements DNACustomRepository {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public DNADTO getByDNA(String dna) {
        javax.persistence.Query query = this.entityManager.createNativeQuery("select * from dna d where d.dna=?1",DNA.class);
        query.setParameter(1, dna);
        Object result= query.getResultList()
                .stream().findFirst().orElse(null);
        if (result!=null){
            DNA entityDNA = (DNA) result;
            return new DNADTO(entityDNA.getId(),entityDNA.getSequence(),
                    entityDNA.getDNA(),entityDNA.getIsMutant());
        }
        return null;
    }

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

    public void save(DNADTO dto)throws Exception{
        this.save(new DNA(dto.getSequence()));
    }

}
