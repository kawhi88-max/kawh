package com.company;

import java.util.Random;

public class Main {

    public static int[] heroesHealth = {270, 280, 250, 300};
    public static String[] heroesNames = {"Lu Kang", "Jax",
            "Scorpion", "Medic 88"};
    public static int[] heroesStrike = {20, 15, 25, 0};


    public static String bossName = " Shao Kahn ";
    public static int bossHealth = 700;
    public static int bossStrike = 50;
    public static String superStrike = " ";
    public static int roundNumber = 0;

    public static void main(String[] args) {
        // write your code here
        System.out.println("-----------The game started----------");


        while (!isGameFinushed()) {
            round();
        }


    }

    public static void round() {
        roundNumber++;
        System.out.println("--------- Round " + roundNumber + "---------");
        superStrike = getSuperStrikeHero();
        System.out.println("Super strike damage " + superStrike);
        printStatistics();
        bossHits();
        heroesHits();
        printStatistics();
        medHelp();
    }

    public static void medHelp() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] <= 100 && heroesHealth[i] > 0
                    && heroesHealth[i] != heroesHealth[3] && heroesHealth[3] > 0) {
                Random rand = new Random();
                int helpMedic = rand.nextInt(10) + 20;
                heroesHealth[i] = heroesHealth[i] + helpMedic;
                System.out.println("Medic Helps " + heroesNames[i] + " and give him " + helpMedic);
                break;
            }
        }
    }


    public static boolean isGameFinushed() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!" +
                    " Mortal Kombat finished ");
            return true;
        }
        boolean allHeroesDead = true;

        for (int heroHealth : heroesHealth) {
            if (heroHealth > 0) {
                allHeroesDead = false;
                break;
            }

        }
        if (allHeroesDead) {
            System.out.println(bossName +
                    "Won !!! Mortal Kombat finished");
        }
        return allHeroesDead;
    }


    public static void heroesHits() {
        Random random = new Random();
        int coeff = random.nextInt(9) + 2;
        for (int i = 0; i < heroesStrike.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (superStrike == heroesNames[i]) ;
                bossHealth = bossHealth - heroesStrike[i] * coeff;
                System.out.println(" Super strike damage " +
                        superStrike + (heroesStrike[i] * coeff ));

                } else {

                    bossHealth = bossHealth - heroesStrike[i];

                }
            }

            if (bossHealth < 0) {
                bossHealth = 0;
            }
        }



    public static void bossHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                heroesHealth[i] = heroesHealth[i] - bossStrike;
            }
            if (heroesHealth[i] < 0) {
                heroesHealth[i] = 0;
            }
        }
    }

    public static String getSuperStrikeHero() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesNames.length);
        return heroesNames[randomIndex];
    }


    public static void printStatistics() {
        System.out.println(bossName + "= health " + bossHealth +
                "[" + bossStrike + "]");
        for (int i = 0; i < heroesNames.length; i++) {
            System.out.println(heroesNames[i] + "=" + "= health" +
                    heroesHealth[i] + "strike [" +
                    heroesStrike[i] + "]");
        }
    }
}
