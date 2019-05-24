package com.rasmus.app.arenafighter.modules;

import com.rasmus.app.arenafighter.App;
import com.rasmus.app.arenafighter.modules.Round;

public class Battle {
	
	public void arenaMenu(){
		MakeEnemy opponent = new MakeEnemy();
		System.out.println("[Todays arena contestant]: " + opponent.getEnemyName() + "\nDo you want to start a fight? (Y/N)");
		System.out.println("HP: " + opponent.getEnemyHitpoints() + " Speed: " + opponent.getEnemySpeed() + " STR: " + opponent.getEnemyStrength() + " WPN: " + opponent.getEnemyHeldItem().getWeaponName());
		String arenaSelection = App.getInput();
		
		if(arenaSelection.equalsIgnoreCase("y")){
			boolean result = inBattle(App.GLADIATOR, opponent);
			if(!result){
				System.out.println("Game over, play again? (Y/N)");
				App.MENUES.endMenu(App.getInput());
			}
		}else{
			System.out.println("Exiting arena...");
		}
	}
	
	public boolean inBattle(PlayerGladiator player, MakeEnemy opponent){
		int rounds = 0;
		while(!(player.getHitpoints() <= 0) && !(opponent.getEnemyHitpoints() <= 0)){
			Round ROUND = new Round();
			ROUND.round(player, opponent);
			rounds++;
		}
		if(opponent.getEnemyHitpoints() <= 0){
			player.restoreHitpoints();
			player.getPaid(100);
			System.out.println("You defeated: " + opponent.getEnemyName() + " In " + rounds + " Rounds! And gained 100$!");
			player.addBattle();
			player.addExperience();
			App.MENUES.pauseReturnTown();
			return true;
		}else{
			System.out.println("[Game Over]\nYou lost in " + rounds + " rounds to " + opponent.getEnemyName() + " And lost 1000 score.");
			player.setDeathPenalty();
			System.out.println("[Death Recap]\n" + "[" + player.getGladiatorName() + "] Battled for " + player.getBattles() + " battles before falling to " + opponent.getEnemyName() + "\n[" + player.getGladiatorName() + "'s] Score before perishing: " + player.getGladiatorScore());
			return false;
		}
	}

}
