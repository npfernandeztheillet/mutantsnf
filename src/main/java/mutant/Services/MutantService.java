package mutant.Services;

import mutant.Business.MutantBusiness;
import mutant.Business.DTOs.DNADTO;
import mutant.Data.Repository.DNARepository;
import mutant.Utils.Helpers.CommonHelper;
import mutant.Utils.Static.Constants;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import net.sf.ehcache.CacheManager;
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

    public boolean isMutant(String[] dna) throws Exception {
        String dnaString = CommonHelper.concatArrayByDelimiter(dna, Constants.DELIMITER);
        DNADTO cacheElement=null;
        DNADTO dnaDTO =null;
        cacheElement= (DNADTO)cache.get(dnaString);
        if (cacheElement == null){
            dnaDTO = dnaRepository.getByDNA(dnaString);
            if (dnaDTO == null){
                MutantBusiness business = new MutantBusiness(Constants.CONSECUTIVECHARS,Constants.MINSEQUENCE);
                dnaDTO= business.analyseDna(new DNADTO(dna,dnaString));
                if (dnaDTO.getIsMutant()){
                    dnaRepository.save(dnaDTO);
                    cache.put(dnaString,dnaDTO);
                }
            }else
                cache.put(dnaString,dnaDTO);
        }else
            dnaDTO=cacheElement;
        return dnaDTO.getIsMutant();
    }
}
