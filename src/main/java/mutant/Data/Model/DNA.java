package mutant.Data.Model;

import mutant.Utils.Helpers.CommonHelper;

import javax.persistence.*;
import mutant.Utils.Static.*;

@Entity
public class DNA {

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

    public DNA(String[] sequence){
        this.sequence = sequence;
        this.dna = CommonHelper.concatArrayByDelimiter(sequence,Constants.DELIMITER);
    }

    public String getDNA() {
        return dna;
    }

    public String[] getSequence() { return this.sequence;}

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
