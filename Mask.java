public class Mask implements Comparable<Mask>{
    private String h;
    private double p;

    public Mask(String h, double p) {
        this.h = h;
        this.p = p;
    }

    @Override
    public int compareTo(Mask o) {
        if (this.p > o.p) {
            return 1;
        } else if (this.p < o.p) {
            return -1;
        } else {
            return 0;
        }
    }
    public String toString()  {
        return this.h;
    }

    public double getValue() {
        return this.p;
    }

}
