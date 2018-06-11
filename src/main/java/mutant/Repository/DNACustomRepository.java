package mutant.Repository;

import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface DNACustomRepository {
    int findByDNA(String dna);
}
