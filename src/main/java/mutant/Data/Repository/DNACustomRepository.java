package mutant.Data.Repository;

import mutant.Business.DTOs.DNADTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface DNACustomRepository {
    int findByDNA(String dna);
    DNADTO getByDNA(String dna);
    void save(DNADTO dto)throws Exception;
}
