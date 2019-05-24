package com.rasmus.app.arenafighter.modules;

import com.rasmus.app.arenafighter.App;
import com.rasmus.app.arenafighter.Weapons;

public class PlayerGladiator {
	public int expCounter = 0;
	
	private String gladiatorName;
	private int strength;
	private int defence;
	private int hitpoints;
	private int constitution;
	private int balance;
	private int speed;
	private int luck;
	private int sp;
	private boolean retired;
	private int gladiatorScore;
	private int battles;
	private boolean retiredBonus;
	private int experience;
	private Weapons heldItem;
	
	public PlayerGladiator(String gladiatorName) {
		this.gladiatorName = gladiatorName;
		strength = 5;
		defence = 5;
		constitution = 5;
		luck = 5;
		hitpoints = (this.defence + this.constitution) * 6;
		retired = false;
		balance = 0;
		battles = 0;
		sp = 0;
		speed = 50;
		gladiatorScore = battles * 1000;
		heldItem = new Weapons("Club", 5);
		experience = 0;
	}
	
	public int getAttacked(int damage) {
		hitpoints = hitpoints - (damage - defence) * 2;
		return (damage - defence) * 2;
	}
	public void restoreHitpoints() {
		this.hitpoints = (this.defence + this.constitution) * 6;
	}


	public String getGladiatorName() {
		return gladiatorName;
	}
	public int getHitpoints() {
		return hitpoints;
	}
	public int getStrength() {
		return strength;
	}
	public int getDefence(){
		return defence;
	}
	public int getConstitution() {
		return constitution;
	}
	public int getSpeed(){
		return speed;
	}
	public int getLuck() {
		return luck;
	}

	
	public Weapons getHeldItem() {
		return heldItem;
	}
	public int getSp(){
		return sp;
	}
	public int getGladiatorScore() {
		return gladiatorScore;
	}
	public int getBattles() {
		return battles;
	}
	public int getBalance() {
		return balance;
	}
	
	
	
	
	public void pay(int number){
		this.balance = balance - number;
	}
	public void getPaid(int number){
		this.balance = balance + number;
	}

	public boolean isRetiredBonus() {
		return retiredBonus;
	}

	public void setRetiredBonus(boolean retiredBonus) {
		this.retiredBonus = retiredBonus;
		this.gladiatorScore = gladiatorScore + 1000;
	}
	
	public void setDeathPenalty(){
		if(!(gladiatorScore <= 0)){
			this.gladiatorScore = gladiatorScore - 1000;
		}
	}
	
	
	public void addStrength() {
		this.strength = strength + 1;
	}
	public void addDefence(){
		this.defence = defence + 1;
	}
	public void addConstitution() {
		this.constitution = constitution + 1;
	}
	public void addLuck() {
		this.luck = luck + 1;
	}
	public int addSpeed(){
		return this.speed = speed + 10;
	}
	public void addSp(){
		this.sp = sp + 1;
	}
	public void addExperience() {
		this.experience = experience + 100;
		expCounter++;
		if(expCounter >= 3){
			addSp();
			expCounter = 0;
			System.out.println("You got a SP point for defeating three enemies!");
		}
	}
	
	
	
	
	
	public void getSP(){ //Only for Cheating
		this.sp = sp + 10;
	}
	public void getRich(){ //Only for Cheating
		this.balance = balance + 1000;
	}
	public void addBattle() {
		this.battles = battles + 1;
	}
	public void setHeldItem(Weapons heldItem) {
		this.heldItem = heldItem;
	}
	
	
	
	public boolean isRetired() {
		return retired;
	}
	public boolean retire(){
		return retired = true;
	}
	
	public boolean isAlive() {
		if(App.GLADIATOR.getHitpoints() <= 0) {
			
			return false;
		}
		return true;
	}

	public void getGladiatorInfo(){
		StringBuilder sb = new StringBuilder();
		sb.append("[Your Gladiator]: [Username: " + getGladiatorName() + "] [Battles: " + getBattles() + "]\n");
		sb.append("[Stats]: [HP: " + getHitpoints() + "] [STR: " + getStrength() + "] [DEF: " + getDefence() + "] [CON: " + getConstitution() + "] [LUCK: " + getLuck() + "] [SPEED: " + getSpeed() + "]\n");
		sb.append("[Weapon: " + getHeldItem().getWeaponName() + "] [Damage: " + getHeldItem().getDamageModifier() + "] [DPS: " + (getStrength() + getHeldItem().getDamageModifier()) + "]\n");
		sb.append("[Balance($): " + getBalance() + "] [SP: " + getSp() + "] [Score: " + getGladiatorScore() + "]");
		System.out.println(sb);
	}
	
}
