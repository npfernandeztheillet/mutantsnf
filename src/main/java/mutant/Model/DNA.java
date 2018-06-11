package mutant.Model;

import mutant.Utils.Helpers.CommonHelper;

import javax.persistence.*;

@Entity
public class DNA {

    private static final String DELIMITER = "-";

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "dna")
    private String dna;

    @Column
    private boolean isMutant = false;

   @Transient
    private String[] secuence;



    public DNA(){}

    public DNA(String[] dna){
        secuence = dna;
        this.dna = CommonHelper.concatArrayByDelimiter(dna,DELIMITER);
    }

    public String toString() {
        return dna;
    }

    public boolean getIsMutant() {
        return isMutant;
    }

    public void setIsMutant(boolean mutant) {
        isMutant = mutant;
    }

    public Integer getId() {
        return id;
    }

}
