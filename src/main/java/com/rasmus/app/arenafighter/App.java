package com.rasmus.app.arenafighter;

import java.io.IOException;
import java.util.Scanner;
import com.rasmus.app.arenafighter.modules.PlayerGladiator;
import com.rasmus.app.arenafighter.modules.Battle;
import com.rasmus.app.arenafighter.modules.MakeEnemy;
import com.rasmus.app.arenafighter.Menues;

public class App {
	public static final Scanner SCANNER = new Scanner(System.in);
	public static boolean INGAME = false;
	public static boolean CHARACTERCREATION = true;
	public static boolean RUNONCE = false;
	public static MakeEnemy ENEMY;
	public static StringBuilder LOG = new StringBuilder();
	public static Menues MENUES = new Menues();
	public static PlayerGladiator GLADIATOR;
	public static Battle BATTLE = new Battle();
	
    public static void main( String[] args ) throws IOException, InterruptedException{
    	com.rasmus.app.arenafighter.CLS.main("");
    	INGAME = MENUES.bootMenu();
    	com.rasmus.app.arenafighter.CLS.main("");
    	do{
    		while(CHARACTERCREATION){
				if(!RUNONCE){
					com.rasmus.app.arenafighter.CLS.main("");
    				System.out.println("[Character Creation]:\nPlease Enter A Name For Your Gladiator:");
    				RUNONCE = true;
    			}else{
    				if(true){
    					MENUES.validNameCheck();
    				}
				}
			}
    		com.rasmus.app.arenafighter.CLS.main("");
	    	if(GLADIATOR.isRetired()){
	    		GLADIATOR.setRetiredBonus(true);
	    		System.out.println("Game over, play again? (Y/N)");
	    		MENUES.endMenu(getInput());
	    		
	    	}else if(!GLADIATOR.isRetired()){
	    		System.out.println(MENUES.townSelections());
	    		String townSelection = getInput();
	    		if(townSelection.equalsIgnoreCase("Arena")){
	    			System.out.println("Entering Arena...");
	    			BATTLE.arenaMenu();
	    		}else if(townSelection.equalsIgnoreCase("Shop")){
	    			boolean shopping = true;
	    			while(shopping){
	    				System.out.println(MENUES.shopSelections());
	    				shopping = MENUES.enterShop(getInput());
	    			}
	    		}else if(townSelection.equalsIgnoreCase("Home")){
	    			MENUES.goHomeRetire();

	    		}else if(townSelection.equalsIgnoreCase("Stats")){
	    			App.GLADIATOR.getGladiatorInfo();
	    			MENUES.pauseReturnTown();
	    		}else if(townSelection.equalsIgnoreCase("Train")){
	    			System.out.println("[Entering Training Grounds]...");
	    			boolean training = true;
	    			while(training){
	    			System.out.println(MENUES.trainingSelections());
	    			training = MENUES.enterTrainingGround(getInput());
	    			}
	    			
	    		}else if(townSelection.equalsIgnoreCase("moresp")){
	    			App.GLADIATOR.getSP();
	    			System.out.println("[CHEAT] - Added one skillpoint to player");
	    		}else if(townSelection.equalsIgnoreCase("motherlode")){
	    			App.GLADIATOR.getRich();
	    			System.out.println("[CHEAT] - Added 1000$");
	    		}else{
	    			System.out.println("That is not a valid destination..");
	    		}
	    		
	    	}else if(!GLADIATOR.isAlive()){
	    		System.out.println("Game over, play again? (Y/N)");
	    		MENUES.endMenu(getInput());
	    	}else{
	    		System.out.println("Game over, play again? (Y/N)");
	    		MENUES.endMenu(getInput());
	    	}
    	}while(INGAME);

    }
    
    public static String getInput(){
    	String input = SCANNER.nextLine();
    	return input;
    } 
}