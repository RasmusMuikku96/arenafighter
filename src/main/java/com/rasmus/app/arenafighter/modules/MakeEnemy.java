package com.rasmus.app.arenafighter.modules;

import java.util.concurrent.ThreadLocalRandom;

import com.rasmus.app.arenafighter.App;
import com.rasmus.app.arenafighter.Weapons;

import roman.randomname.generator.roman_name_generator.RomanNameGenerator;

public class MakeEnemy {
	
	private int RANDOMSTATGENERATOR = ThreadLocalRandom.current().nextInt(-3, 3);
	private int RANDOMSTATGENERATORCON = ThreadLocalRandom.current().nextInt(-1, 1);
	private int RANDOMSTATGENERATORSPD = ThreadLocalRandom.current().nextInt(-5, 5);
	
	private String enemyName;
	private int enemyStrength;
	private int enemyDefence;
	private int enemyHitpoints;
	private int enemyConstitution;
	private int enemySpeed;
	private int enemyLuck;
	private Weapons enemyHeldItem;
	
	public MakeEnemy() {
		this.enemyName = makeOpponentName();
		enemyStrength = App.GLADIATOR.getStrength() + RANDOMSTATGENERATOR;
		enemyDefence = App.GLADIATOR.getDefence() + RANDOMSTATGENERATORCON;
		enemyConstitution = App.GLADIATOR.getConstitution() + RANDOMSTATGENERATORCON;
		enemySpeed = App.GLADIATOR.getSpeed() + RANDOMSTATGENERATORSPD;
		enemyLuck = App.GLADIATOR.getLuck() + RANDOMSTATGENERATORCON;
		enemyHitpoints = (this.enemyDefence + this.enemyConstitution) * 6;
		enemyHeldItem = generateEnemyWeapon();
	}
	
	public Weapons generateEnemyWeapon(){
		if(App.GLADIATOR.getHeldItem().getDamageModifier() >= 4){
			return new Weapons("Club", 5);
		}if(App.GLADIATOR.getHeldItem().getDamageModifier() >= 9){
			return new Weapons("Sword", 10);
		}if(App.GLADIATOR.getHeldItem().getDamageModifier() >= 14){
			return new Weapons("War Axe", 15);
		}if(App.GLADIATOR.getHeldItem().getDamageModifier() >= 19){
			return new Weapons("BroadSword", 20);
		}if(App.GLADIATOR.getHeldItem().getDamageModifier() >= 24){
			return new Weapons("Katana", 25);
			
		}else{ // -Default Weapon-
			return new Weapons("Club", 5);
		}
	}
	
	public Weapons getEnemyHeldItem() {
		return enemyHeldItem;
	}

	public int getEnemyLuck(){
		return this.enemyLuck;
	}
	
	public int getEnemyStrength(){
		return this.enemyStrength;
	}

	public int getEnemySpeed(){
		return this.enemySpeed;
	}
	
	public int getEnemyHitpoints() {
		return enemyHitpoints;
	}

	public int getAttacked(int damage) {
		enemyHitpoints = enemyHitpoints - (damage - enemyDefence) * 2;
		return (damage - enemyDefence) * 2;
	}

	public String getEnemyName() {
		return enemyName;
	}

	public String makeOpponentName(){
	RomanNameGenerator generator = new RomanNameGenerator();
	String opponent = generator.getFullName();
	return opponent;
	}
}
