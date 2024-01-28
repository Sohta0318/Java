package dev.lpa;

import java.util.Arrays;
import java.util.concurrent.Executors;

record Participant(String name, String searchingFor, Maze maze, int[] startingPosition){
    Participant{
        maze.moveLocation(startingPosition[0], startingPosition[1], name);
    }
}

class ParticipantThread extends Thread{
    public final Participant participant;

    public ParticipantThread(Participant participant) {
        super(participant.name());
        this.participant = participant;
    }

    @Override
    public void run(){
        int[] lastStops = participant.startingPosition();
        Maze maze = participant.maze();

        while(true){
            int[] newStop = maze.getNextLocation(lastStops);
try{
    Thread.sleep(participant.name().equals("Grace") ? 2900 : 500);
    if(maze.searchCell(participant.searchingFor(), newStop, lastStops)){
        System.out.printf("%s found %s at %s!%n",participant.name(),
                participant.searchingFor(), Arrays.toString(newStop));
        break;
    }
    synchronized (maze){
        maze.moveLocation(newStop[0], newStop[1], participant.name());
    }
    lastStops = new int[]{newStop[0], newStop[1]};
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
    return;
}
            System.out.println(participant.name() + " searching " + participant.maze() );
        }
    }

}

public class MazeRunner {
    public static void main(String[] args) {
Maze maze = new Maze();
Participant adam = new Participant("Adam", "Grace", maze, new int[]{3,3});
        Participant grace = new Participant("Grace", "Adam", maze, new int[]{1,1});
        System.out.println(maze);

        var executors = Executors.newCachedThreadPool();
        var adamsResult = executors.submit(new ParticipantThread(adam));
        var gracesResult = executors.submit(new ParticipantThread(grace));

        while (!adamsResult.isDone() && !gracesResult.isDone()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(adamsResult.isDone()){
            gracesResult.cancel(true);
        } else if (gracesResult.isDone()) {
            adamsResult.cancel(true);
        }
        executors.shutdown();


    }
}
