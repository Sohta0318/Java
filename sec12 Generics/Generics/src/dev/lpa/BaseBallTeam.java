package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class BaseBallTeam {
    private String teamName;
    private List<BaseballPlayer> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLoses = 0;
    private int totalTies = 0;

    public BaseBallTeam(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(BaseballPlayer player){
        if(!teamMembers.contains(player)){
            teamMembers.add(player);
        }
    }

    public void listTeamMember(){
        System.out.println(teamName + " Roster:");
        System.out.println(teamMembers);
    }
    public int ranking(){
        return (totalLoses * 2) + totalTies + 1;
    }
    public String setScore(int ourScore, int theirScore){
        String message = "lost to";
        if(ourScore > theirScore){
            message = "beat";
        }else if(ourScore == theirScore){
            message = "tied";
            totalTies++;
        }else {
            totalLoses++;
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}
