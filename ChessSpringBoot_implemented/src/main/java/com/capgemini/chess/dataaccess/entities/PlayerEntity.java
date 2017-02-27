package com.capgemini.chess.dataaccess.entities;

public class PlayerEntity {
	private Long id;
	private int lvl;
	private int pkt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public int getPkt() {
		return pkt;
	}
	public void setPkt(int pkt) {
		this.pkt = pkt;
	}
}
