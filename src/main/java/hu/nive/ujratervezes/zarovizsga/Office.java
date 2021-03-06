package hu.nive.ujratervezes.zarovizsga;

public class Office implements Cleanable {

    private String adderess;
    private int quadratm;
    private int levels;

    public Office(String adderess, int quadratm, int levels) {
        this.adderess = adderess;
        this.quadratm = quadratm;
        this.levels = levels;
    }

    @Override
    public int clean() {
        return quadratm*100*levels;
    }

    @Override
    public String getAddress() {
        return adderess;
    }
}
