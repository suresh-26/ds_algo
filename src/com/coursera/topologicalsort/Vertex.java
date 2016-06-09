package com.coursera.topologicalsort;

class Vertex {
	char name;
	Vertex [] Outs;
	int numOuts;
	int N;
	int L;
	boolean visited=false;
	
	
	public Vertex(char v) {
		name=v;
		numOuts=0;
		Outs = new Vertex[100];
	}
	
	public char getName() {
		return name;
	}
	
	public void setOuts(Vertex v) {
		numOuts++;
		Outs[numOuts]=v;
	}
	public int getOutsNum() {
		return numOuts;
	}
	
	public Vertex getOuts(int i) {
		return Outs[i];
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited() {
		visited=true;
	}
	public void setL(int v) {
		L=v;
	}
	public void setN(int v) {
		N=v;
	}
	public int getL() {
		return L;
	}
	public int getN() {
		return N;
	}
	
	public void display() {
		System.out.print(name);
		System.out.println("  N:"+N+" L:"+L);
	}
	
		
}

