package com.rasmus.app.arenafighter.modules;

import java.util.concurrent.ThreadLocalRandom;

public class Round {
	
	public void round(PlayerGladiator player, MakeEnemy opponent){
		int playerspeed = player.getSpeed();
		int enemyspeed = opponent.getEnemySpeed();
		playerspeed = (ThreadLocalRandom.current().nextInt(0, 70) + playerspeed);
		enemyspeed = (ThreadLocalRandom.current().nextInt(0, 70) + enemyspeed);
		int playerLuck = ThreadLocalRandom.current().nextInt(0, 100);
		int enemyLuck = ThreadLocalRandom.current().nextInt(0, 100);
		int finalPlayerLuck = 0;
		int finalOpponentLuck = 0;
		
		if(playerLuck >= 90){
			finalPlayerLuck = player.getLuck() * 2;
		}
		if(enemyLuck >= 90){
			finalOpponentLuck = opponent.getEnemyLuck() * 2;
		}
		
		if(enemyspeed <= playerspeed){
			int damage = opponent.getAttacked(player.getStrength() + player.getHeldItem().getDamageModifier() + finalPlayerLuck);
			System.out.println("[" + player.getGladiatorName() + "]" + " Attacked " + "[" + opponent.getEnemyName() + " for: " + damage + "!");
			if(finalPlayerLuck != 0){
				System.out.println("[" + player.getGladiatorName() + "] hit a critical hit!");
			}
		}else{
			int damage = player.getAttacked(opponent.getEnemyStrength() + opponent.getEnemyHeldItem().getDamageModifier() + finalOpponentLuck);
			System.out.println("[" + opponent.getEnemyName() + "]" + " Attacked " + "[" + player.getGladiatorName() + "]" + " for: " + damage + "!");
			if(finalOpponentLuck != 0){
				System.out.println("[" + opponent.getEnemyName() + "] hit a critical hit!");
			}
		}
	}
	
}
