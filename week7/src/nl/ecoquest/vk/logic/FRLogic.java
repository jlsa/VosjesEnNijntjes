package nl.ecoquest.vk.logic;

import nl.ecoquest.vk.exception.*;
import java.util.*;

public class FRLogic extends AbstractModel implements Runnable {
	private int size;
	private static final int MIN_SIZE = 10;
	private static final int MAX_SIZE = 250;
	private boolean sizeIsSet;
	
	private float degree;
	private static final float MIN_DEGREE = 0.0f;
	private static final float MAX_DEGREE = 1.0f;
	private boolean degreeIsSet;
	
	private boolean initRun;
	
	private int[][] fieldOriginal;
	private int[][] fieldUnderConstruction;
	private Random r;
	
	private int numOfSteps;
	private int stepsTaken;
	private boolean run;
	
	public FRLogic() {
		size = MIN_SIZE - 1;
		degree = MIN_DEGREE - 1;
		sizeIsSet = false;
		degreeIsSet = false;
		stepsTaken = 0;
		r = new Random();
		run = false;
	}
	
	public void setSize(int size) throws FRException {
		if(size < MIN_SIZE) {
			throw new FRException("Size too small");
		}
		if(size > MAX_SIZE) {
			throw new FRException("Size too big");
		}
		
		this.size = size;
		sizeIsSet = true;
		fieldOriginal = new int[size][size];
		fieldUnderConstruction = new int[size][size];
		initRun = false;
	}
	
	public void setDegree(float degree) throws FRException {
		if(degree < MIN_DEGREE) {
			throw new FRException("Degree too small");
		}
		if(degree > MAX_DEGREE) {
			throw new FRException("Degree too big");
		}
		
		this.degree = degree;
		degreeIsSet = true;
		initRun = false;
	}
	
	public void doStep() throws FRException {
		if(!sizeIsSet || !degreeIsSet) {
			throw new FRException("Size and/or degree is not set yet");
		}
		if(!initRun) {
			throw new FRException("Run init first");
		}
		calculateRound();
		notifyViews();
	}
	
	public void doSteps(int numOfSteps) throws FRException {
		if(!sizeIsSet || !degreeIsSet) {
			throw new FRException("Size and/or degree is not set yet");
		}
		if(!initRun) {
			throw new FRException("Run init first");
		}
		if(run) {
			throw new FRException("Already running");
		}
		this.numOfSteps = numOfSteps;
		run = true;
		new Thread(this).start();
	}
	
	public void stopSteps() {
		run = false;
	}
	
	public int[][] getState() {
		return fieldOriginal;
	}
	
	public void randomInit() throws FRException {
		if(!sizeIsSet || !degreeIsSet) {
			throw new FRException("Size and/pr degree is not set yet");
		}
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(r.nextFloat() <= degree) {
					fieldOriginal[i][j] = 1;
				} else {
					fieldOriginal[i][j] = 0;
				}
			}
		}
		initRun = true;
		notifyViews();
	}
	
	private void calculateRound() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				int count = 0;
				for(int k = Math.max(0, i-1); k <= Math.min(size-1,  i+1); k++) {
					for(int l = Math.max(0, j-1); l <= Math.min(size-1,  j+1); l++) {
						count += fieldOriginal[k][l];
					}
				}
				System.out.println(count); // oh :)
				if(fieldOriginal[i][j] == 1) {
					count--;
				}
				if(count == 2 || count == 3) {
					fieldUnderConstruction[i][j] = 1;
				} else {
					fieldUnderConstruction[i][j] = 0;
				}
			}
		}
		int[][] temp = fieldOriginal;
		fieldOriginal = fieldUnderConstruction;
		fieldUnderConstruction = temp;
	}
	


	@Override
	public void run() {
		for(int i = 0; i < numOfSteps && run; i++) {
			stepsTaken++; // thread sensitive or not?
			calculateRound();
			notifyViews();
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		run = false;
	}
	
	public int getStepsTaken() {
		return stepsTaken;
	}
}
