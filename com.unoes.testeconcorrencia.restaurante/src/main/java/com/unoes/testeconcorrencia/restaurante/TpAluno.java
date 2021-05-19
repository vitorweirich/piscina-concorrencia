package com.unoes.testeconcorrencia.restaurante;

import java.util.concurrent.Semaphore;

public class TpAluno extends Thread {
	private int idThread;
	private Semaphore semaforo;

	public TpAluno(int id, Semaphore semaphore) {
		this.idThread = id;
		this.semaforo = semaphore;
	}

	@Override
	public void run() {
		while (true) {
			caminha(idThread);
			try {
				semaforo.acquire();
				almoca(idThread);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
	}

	private void almoca(int n) {
		System.out.println("Aluno  " + n + " almoçando");
		try {
			Thread.sleep((long) (Math.random() * 10000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void caminha(int n) {
		System.out.println("Aluno  " + n + " caminhando");
		try {
			Thread.sleep((long) (Math.random() * 10000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
