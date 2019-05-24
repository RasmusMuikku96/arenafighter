package com.rasmus.app.arenafighter;

public class Weapons {
	private String weaponName;
	private int damageModifier;
	
	public Weapons(String weaponName, int damageModifier) {
		this.weaponName = weaponName;
		this.damageModifier = damageModifier;
	}
	
	public String getWeaponName() {
		return weaponName;
	}
	
	public int getDamageModifier() {
		return this.damageModifier;
	}
	
}
