package com.rasmus.app.arenafighter;

import com.rasmus.app.arenafighter.App;
import com.rasmus.app.arenafighter.modules.PlayerGladiator;

public class Menues {
	public boolean bootMenu(){
    	System.out.println(" ____________________________________\n"
    			+ "|                                    |\n"
    			+ "|     Welcome to: Arena Fighter!     |\n"
    			+ "|     Press [Enter] to continue      |\n"
    			+ "|____________________________________|");
		App.getInput();
    	System.out.println("[Starting Game...]");
    	return true;
    }
	
	public void pauseReturnTown(){
		System.out.println("Press Enter to return to town..");
		App.getInput();
	}
	public void goHomeRetire(){
		System.out.println("You feel weary and tired.. You retire as a gladiator and go home..");
		System.out.println("Your Final Score: " + App.GLADIATOR.getGladiatorScore());
		App.GLADIATOR.retire();
		System.out.println("\nYou retired, Play again? (Y/N)");
		App.MENUES.endMenu(App.getInput());
	
	}
	
	public boolean enterShop(String shopSelection){
		if(shopSelection.equals("1")){
			boolean placeholderItem = validateBuyShop("Sword", 10, 200);
			if(placeholderItem){
				System.out.println("[Shop] Successfully Bought " + App.GLADIATOR.getHeldItem().getWeaponName() + ". You Instantly Switch Out Your Weapon.");
				return true;
			}else{
				insufficientFundsWeap();
				return true;
			}
		}else if(shopSelection.equals("2")){
			boolean placeholderItem = validateBuyShop("War Axe", 15, 400);
			if(placeholderItem){
				System.out.println("[Shop] Successfully Bought " + App.GLADIATOR.getHeldItem().getWeaponName() + ". You Instantly Switch Out Your Weapon.");
				return true;
			}else{
				insufficientFundsWeap();
				return true;
			}
		}else if(shopSelection.equals("3")){
			boolean placeholderItem = validateBuyShop("BroadSword", 20, 600);
			if(placeholderItem){
				System.out.println("[Shop] Successfully Bought " + App.GLADIATOR.getHeldItem().getWeaponName() + ". You Instantly Switch Out Your Weapon.");
				return true;
			}else{
				insufficientFundsWeap();
				return true;
			}
		}else if(shopSelection.equals("4")){
			boolean placeholderItem = validateBuyShop("Katana", 25, 800);
			if(placeholderItem){
				System.out.println("[Shop] Successfully Bought " + App.GLADIATOR.getHeldItem().getWeaponName() + ". You Instantly Switch Out Your Weapon.");
				return true;
			}else{
				insufficientFundsWeap();
				return true;
			}		
		}else if(shopSelection.equals("5")){
			if(App.GLADIATOR.getBalance() >= 80){
				System.out.println("TODO NOT YET IMPLEMENTED\nNOTHING WAS DEDUCTED FROM YOUR ACCOUNT");
				return true;
			}else{
				insufficientFunds();
				return true;
			}
		}else if(shopSelection.equalsIgnoreCase("exit")){
			System.out.println("[Exiting Shop]");
			return false;
		}else{
			return true;
		}
	}
	
	public boolean validateBuyShop(String weaponName, int damage, int pay){
		if(App.GLADIATOR.getHeldItem().getDamageModifier() < damage && (App.GLADIATOR.getBalance() >= pay)){
			App.GLADIATOR.setHeldItem(new Weapons(weaponName, damage));
			App.GLADIATOR.pay(pay);
			return true;
		}else{
			return false;
		}
	}
	
	public StringBuilder shopSelections(){
    	StringBuilder sl = new StringBuilder();
    	int shopNum = 0;
    	shopNum++;
    	//sl.append("");
    	sl.append("[Shop]: [You have: " + App.GLADIATOR.getBalance() + "$]\n");
    	sl.append("-(" + shopNum++ + ") [Buy(200$): Sword] [DMG: 10]\n"); // shopnum 1
    	sl.append("-(" + shopNum++ + ") [Buy(400$): War Axe] [DMG: 15]\n"); // shopnum 2
    	sl.append("-(" + shopNum++ + ") [Buy(600$): BroadSword] [DMG: 20]\n"); // shopnum 3
    	sl.append("-(" + shopNum++ + ") [Buy(800$): Katana] [DMG: 25]\n"); // shopnum 4
    	
    	sl.append("-(" + shopNum++ + ") [Buy(80$): Small Red Potion] [Heals: 40HP]\n");
    	
    	sl.append(" \n");
    	sl.append("-(exit) [Go Back To Town]");
    	return sl;
    }
	
	public StringBuilder trainingSelections(){
		StringBuilder ts = new StringBuilder();
		int trNum = 0;
		trNum++;
		ts.append("Your SP: " + App.GLADIATOR.getSp() + "\n");
		ts.append("-(" + trNum++ + ") [Train your STR] Current Strength: " + App.GLADIATOR.getStrength() + " = (1+) [Costs: 1 SP]\n");
		ts.append("-(" + trNum++ + ") [Train your DEF] Current Defence: " + App.GLADIATOR.getDefence() + " = (1+) [Costs: 1 SP]\n");
		ts.append("-(" + trNum++ + ") [Train your CON] Current Constitution: " + App.GLADIATOR.getConstitution() + " = (1+) [Costs: 1 SP]\n");
		ts.append("-(" + trNum++ + ") [Train your LUCK] Current Luck: " + App.GLADIATOR.getLuck() + " = (1+) [Costs: 1 SP]\n");
		ts.append("-(" + trNum++ + ") [Train your SPEED] Current Speed: " + App.GLADIATOR.getSpeed() + " = (10+) [Costs: 1 SP]\n");
		
		ts.append("\n");
		ts.append("-(exit) [Go Back To Town]");
		return ts;
	}
	
	public boolean enterTrainingGround(String trainingSelection){
		if(trainingSelection.equals("1")){
			if(!(App.GLADIATOR.getSp() <= 0)){
				App.GLADIATOR.addStrength();
				System.out.println("You increased your strength level");
				return true;
			}else{
				insufficientSP();
				return true;
			}
		}else if(trainingSelection.equals("2")){
			if(!(App.GLADIATOR.getSp() <= 0)){
				App.GLADIATOR.addDefence();
				System.out.println("You increased your defence level");
				return true;
			}else{
				insufficientSP();
				return true;
			}
		}else if(trainingSelection.equals("3")){
			if(!(App.GLADIATOR.getSp() <= 0)){
				App.GLADIATOR.addConstitution();
				System.out.println("You increased your constitution level");
				return true;
			}else{
				insufficientSP();
				return true;
			}
		}else if(trainingSelection.equals("4")){
			if(!(App.GLADIATOR.getSp() <= 0)){
				App.GLADIATOR.addLuck();
				System.out.println("You increased your luck level");
				return true;
			}else{
				insufficientSP();
				return true;
			}
		}else if(trainingSelection.equals("5")){
			if(!(App.GLADIATOR.getSp() <= 0)){
				App.GLADIATOR.addSpeed();
				System.out.println("You increased your speed");
				return true;
			}else{
				insufficientSP();
				return true;
			}
			
		}else if(trainingSelection.equalsIgnoreCase("exit")){
			System.out.println("[Exiting Training Grounds]...");
			return false;
		}else{
			return true;
		}
	}
	
	public void winMenuRecap(){
		
		System.out.println("You won");
		
	}
	
	public void endMenu(String endSelection){
		if(endSelection.equalsIgnoreCase("y")){
			System.out.println("Restarting..");
			App.CHARACTERCREATION = true;
			App.INGAME = true;
			App.RUNONCE = false;
		}else{
			App.INGAME = false;
			System.out.println("Exiting game, goodbye.");
		}
		
	}
	
	public void insufficientFunds(){
		System.out.println("Insufficient ($) to buy that.");
	}
	
	public void insufficientFundsWeap(){
		System.out.println("Insufficient ($) to buy that. Or you have a better weapon!");
	}
	
	public void insufficientSP(){
		System.out.println("Insufficient [SP] to train that!");
	}
	
	public boolean validNameCheck(){
    	String check = App.getInput();
    	if(check.length() >= 3){
    		App.GLADIATOR = new PlayerGladiator(check);
    		App.CHARACTERCREATION = false;
    		//System.out.println("[Successfully created your character: " + App.GLADIATOR.getGladiatorName() + " ]");
    		return true;
    	}else{
    		System.out.println("[Your username needs to be 3 or more characters. Try again.]");
    		return false;
    	}
    }
	
	public StringBuilder townSelections(){
		StringBuilder ts = new StringBuilder();
		ts.append("[Entering Town]...\n");
		ts.append("Where do you want to go?\n");
		ts.append("Valid destinations:\n");
		ts.append("- Arena\n");
		ts.append("- Shop\n");
		ts.append("- Train (Training Grounds)\n");
		ts.append("- Stats\n");
		ts.append("- Home (Retire)\n");
		return ts;	
	}
	
}
