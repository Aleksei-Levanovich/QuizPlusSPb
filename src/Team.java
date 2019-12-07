public class Team implements Comparable<Team>{
    private String teamName;
    private float[] points;
    private float sum;
    private int rounds;

    public String getTeamName() {
        return teamName;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public float[] getPoints() {
        return points;
    }

    public void setPoints(float[] points) {
        this.points = points;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    @Override
    public int compareTo(Team o) {
        int result = (int) (-this.getSum()*10+o.getSum()*10);
        if (result==0 && this.getPoints().length==(rounds-1)){
            result=(int) (-this.getPoints()[(rounds-2)]*10+o.getPoints()[(rounds-2)]*10);
        }
        if (result==0 && this.getPoints().length==rounds){
            result=(int) (-this.getPoints()[(rounds-1)]*10+o.getPoints()[(rounds-1)]*10);
        }
        return result;
    }
}
