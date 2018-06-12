package mutant.Model;

import mutant.Utils.Helpers.CommonHelper;

import javax.persistence.*;

@Entity
public class DNA {

    private static final String DELIMITER = "-";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dna")
    private String dna;

    @Column(name = "ismutant")
    private boolean isMutant = false;

   @Transient
    private String[] sequence;



    public DNA(){}

    public DNA(String[] dna){
        sequence = dna;
        this.dna = CommonHelper.concatArrayByDelimiter(dna,DELIMITER);
    }

    public String getDNA() {
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
