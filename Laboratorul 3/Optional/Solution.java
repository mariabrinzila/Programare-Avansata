public class Solution {
    private int costMinim;
    private String drum;

    public Solution() {

    }

    public Solution(int costMinim, String drum) {
        this.costMinim = costMinim;
        this.drum = drum;
    }

    public int getCostMinim() {
        return costMinim;
    }

    public void setCostMinim(int costMinim) {
        this.costMinim = costMinim;
    }

    public String getDrum() {
        return drum;
    }

    public void setDrum(String drum) {
        this.drum = drum;
    }
}
