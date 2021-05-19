package com.unoes.testeconcorrencia.restaurante;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Restaurante {

	public static void main(String[] args) {
	    int mesas = 5;
	    int alunos = 20;
//	    Semaphore semaphore = new Semaphore(mesas);
//	    TpAluno[] processos = new TpAluno[alunos];
//	    for (int i = 0; i < alunos; i++) {
//	        processos[i] = new TpAluno(i, semaphore);
//	        processos[i].start();
//	    }
	    Semaphore semaphore = new Semaphore(mesas);
	    ArrayList<TpAluno> alunosTheread = new ArrayList<TpAluno>();
	    for (int i = 0; i < alunos; i++) {
	    	alunosTheread.add(new TpAluno(i, semaphore));
	    	alunosTheread.get(i).start();
	    }
	}
}
