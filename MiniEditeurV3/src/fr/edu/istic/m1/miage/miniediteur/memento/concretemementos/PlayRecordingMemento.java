package fr.edu.istic.m1.miage.miniediteur.memento.concretemementos;

import fr.edu.istic.m1.miage.miniediteur.memento.Memento;

public class PlayRecordingMemento implements Memento {
	private final String type = "PlayRecording";
	private String state;
	private String stateAfter;
	public PlayRecordingMemento(String state,String stateAfter) {
		// TODO Auto-generated constructor stub
		this.setState(state);
		this.setStateAfter(stateAfter);
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	public String getState() {
		return state;
	}
	private void setState(String state) {
		this.state = state;
	}
	public String getStateAfter() {
		return stateAfter;
	}
	private void setStateAfter(String stateAfter) {
		this.stateAfter = stateAfter;
	}

}
