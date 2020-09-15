package controller;

import java.util.Random;

public class Corrida extends Thread{	
	
	String sapo;
	int salto;
	int distanciaPercorrida = 0;
	int distanciaTotal = 100;
	static int posicao;
	Random random = new Random();
	
	public Corrida(int idThread) {
		this.sapo = "Sapo " + idThread;
	}
	
	private void sapoPulando() {
		salto = random.nextInt(11);
		distanciaPercorrida += salto;
	}
	
	private void statusSapo() {
		System.out.println(sapo + " saltou: " + salto + " metros e percorreu " + distanciaPercorrida + " metros.");
	}
	
	private void descansaSapo() {
		yield();
	}
	
	private void posicaoSapo() {
		posicao++;
		System.out.println(sapo + " terminou no " + posicao + "º lugar.");
	}
	
	public void run() {
		while (distanciaPercorrida < distanciaTotal) {
			sapoPulando();
			statusSapo();
			descansaSapo();
		}
		posicaoSapo();
	}	
}