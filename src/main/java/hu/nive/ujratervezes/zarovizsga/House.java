package hu.nive.ujratervezes.zarovizsga;

public class House implements Cleanable{

    private String adderess;
    private int quadratm;


    public House(String adderess, int quadratm) {
        this.adderess = adderess;
        this.quadratm = quadratm;
    }

    public String getAdderess() {
        return adderess;
    }

    public int getQuadratm() {
        return quadratm;
    }

    @Override
    public int clean() {
        return quadratm*80;
    }

    @Override
    public String getAddress() {
        return adderess;
    }
}
