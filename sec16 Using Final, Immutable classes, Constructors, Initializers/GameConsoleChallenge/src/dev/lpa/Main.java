package dev.lpa;

import dev.lpa.game.Game;
import dev.lpa.game.GameConsole;
import dev.lpa.game.ShooterGame;
import dev.lpa.pirate.Pirate;
import dev.lpa.pirate.PirateGame;
import dev.lpa.pirate.Weapon;

public class Main {
    public static void main(String[] args) {
//        var console = new GameConsole<>(new ShooterGame("The Shootout Game"));
//        int playerIndex = console.addPlayer();
//        console.playGame(playerIndex);

        Weapon weapon = Weapon.getWeaponByChar('P');
        System.out.println("weapon = " + weapon + ", hitPoints = " + weapon.getHitPoints() + ", minLevel = " + weapon.getMinLevel());

        var list = Weapon.getWeaponsByLevel(1);
        list.forEach(System.out::println);

        Pirate tim = new Pirate("Tim");
        System.out.println(tim);

        PirateGame.getTown(0).forEach(System.out::println);
        System.out.println("-".repeat(30));
        PirateGame.getTown(1).forEach(System.out::println);

        var console = new GameConsole<>(new PirateGame("The Pirate Game"));
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);

    }

}
