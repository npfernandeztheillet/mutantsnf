package mutant.Business.DTOs;

public class DNADTO {

    private Integer id;
    private String dna;
    private boolean isMutant = false;
    private String[] sequence;

    public DNADTO(String[] sequence,String dna){
        this.id=id;
        this.sequence = sequence;
        this.dna = dna;
        this.isMutant=isMutant;
    }

    public DNADTO(Integer id, String[] sequence,String dna, boolean isMutant){
        this.id=id;
        this.sequence = sequence;
        this.dna = dna;
        this.isMutant=isMutant;
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

    public String [] getSequence() { return this.sequence;}
}
