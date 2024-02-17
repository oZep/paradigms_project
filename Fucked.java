public class Fucked implements Comparable<Fucked>{
    private String hahah;
    private double pissed;

    public Fucked(String hahah, double pissed) {
        this.hahah = hahah;
        this.pissed = pissed;
    }

    @Override
    public int compareTo(Fucked o) {
        if (this.pissed > o.pissed) {
            return 1;
        } else if (this.pissed < o.pissed) {
            return -1;
        } else {
            return 0;
        }
    }
    public String toString()  {
        return this.hahah;
    }

    public double getValue() {
        return this.pissed;
    }

}
