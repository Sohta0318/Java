package dev.lpa.game;

public record Shooter(String name) implements Player {
    boolean findPrize(){
        System.out.println("Prize found, score should be adjusted.");
        return false;
    }

    boolean useWeapon(String weapon){
        System.out.println("You shot your " + weapon);
        return false;
    }
}
//class Test implements Player{
//
//    @Override
//    public String name() {
//        return null;
//    }
//}
