package mutant.Services;

import mutant.Business.MutantBusiness;
import mutant.Business.DTOs.DNADTO;
import mutant.Data.Repository.DNARepository;
import mutant.Utils.Helpers.CommonHelper;
import mutant.Utils.Static.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantService {

    @Autowired
    private DNARepository dnaRepository;

    @Autowired
    private CacheService cache;

    public MutantService(){
    }

    /**
     *
     *First, it is verified if the DNA sequence sent is valid.
     *Then it looks if it is in the cache. In the case that is found, it is return the value of getIsMutant().
     *If not, it is searched in the database, if it is, it is added to the cache and return the value of getIsMutant().
     * If not, the sequence is analyzed, it is added to the database and to the cache and return the value of getIsMutant().
     * @param dna sequence
     * @return true, if more than MINSEQUENCE strings of CONSECUTIVECHARS valid consecutive characters are found, false in other case.
     * @throws Exception InvalidException or any exception in the process.
     */
    public boolean isMutant(String[] dna) throws Exception {
        String dnaString = CommonHelper.concatArrayByDelimiter(dna, Constants.DELIMITER);
        DNADTO cacheElement;
        DNADTO dnaDTO = new DNADTO(dna,dnaString);
        MutantBusiness business = new MutantBusiness(Constants.CONSECUTIVECHARS,Constants.MINSEQUENCE);
        business.validateDNA(dnaDTO);
        cacheElement= (DNADTO)cache.get(dnaString);
        if (cacheElement == null){
            DNADTO dbDTO = dnaRepository.getByDNA(dnaString);
            if (dbDTO == null){
                dnaDTO= business.analyseDna(dnaDTO);
                dnaRepository.save(dnaDTO);
                cache.put(dnaString,dnaDTO);
            }else
                cache.put(dnaString,dnaDTO=dbDTO);
        }else
            dnaDTO=cacheElement;
        return dnaDTO.getIsMutant();
    }
}
