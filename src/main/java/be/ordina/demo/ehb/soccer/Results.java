package be.ordina.demo.ehb.soccer;

public class Results {

    private Integer goals = 0;
    private Integer catches = 0;

    public Integer getGoals() {
        return goals;
    }

    void addGoal(){
        this.goals++;
    }

    void addCatch(){
        this.catches++;
    }

    public Integer getCatches() {
        return catches;
    }
}
