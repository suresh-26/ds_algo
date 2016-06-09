package com.coursera.topologicalsort;

import java.util.Stack;

public class TopologicalSort {
	
	public Stack getStk() {
		return stk;
	}


	public void setStk(Stack stk) {
		this.stk = stk;
	}

	Stack stk;
	Vertex [] stkArray;
	int c;
	static boolean [] isViisitedBySameLoop;
	
	public TopologicalSort() {
		stk =new Stack();
		c=1;
	}
	
	
	void dfs(Vertex v) {
		System.out.println("Visiting "+v.getName());
		//mark v visited
		v.setVisited();
		//get the number of OUT(V)
		int numouts=v.getOutsNum();

		//copies v.getOuts(i), the out vertices of v, to a temporary array outs[i]
		Vertex [] outs= new Vertex[numouts+1];
		for (int i=1;i<=numouts;i++) outs[i]=v.getOuts(i);
		//for each w in OUT(v) do
		for (int i=1;i<=numouts;i++) {
			Vertex w=outs[i];
			System.out.println(v.getName()+" now looks at "+w.getName());

			//if w is unvisited then dfs(w)
			//if(!w.isVisited()) {
				System.out.println("recurrsively visiting nodes: "+w.getName());
				dfs(w);
			//}
		}
		//push(v) into STACK
		
		
			if(stk.contains(v)&&v.isVisited()){
				System.out.println("graph is not cyclic, topological sort not possible "+v.getName());	
				//System.exit(0);
			}else{
				stk.push(v); 
				System.out.println("STACK: "+v.getName()+" pushed");
			}
	}
	
	public static void main(String[] args){
		TopologicalSort ts=new TopologicalSort();

		////////////////////////////////////////
		// GRAPH LOADING START
		////////////////////////////////////////

		int numVertex=6;
		
		Vertex[] V= new Vertex[numVertex+1];
		isViisitedBySameLoop =new boolean[numVertex+1];
		V[1]=new Vertex('1');
		V[2]=new Vertex('2');
		V[3]=new Vertex('3');
		V[4]=new Vertex('4');
		V[5]=new Vertex('5');
		V[6]=new Vertex('6');
		
		
		
		//1-> 2,3
		V[1].setOuts(V[3]);
		V[1].setOuts(V[2]);
		//V[1].setOuts(V[4]);
		
		//2->3,4
		V[2].setOuts(V[4]);
		V[2].setOuts(V[3]);
		
		//3->5
		V[3].setOuts(V[5]);
		//V[3].setOuts(V[2]);
		
		//4->6
		V[4].setOuts(V[5]);
		V[4].setOuts(V[6]);
		//5->4,6
//		V[5].setOuts(V[6]);
//		V[5].setOuts(V[4]);
		V[5].setOuts(V[6]);
		
		//V[6].setOuts(V[1]);
		//V[6].setOuts(V[2]);
		
		//V[5].setOuts(V[3]);
		
		//////////////////////////////////////////
		// GRAPH LOADING END
		//////////////////////////////////////////
		
						
		//Check if the graph is correctly loaded
		System.out.println("graph representaion");
		for (int i=1;i<=numVertex;i++) {
			System.out.print(V[i].getName()+"=>");
			for (int j=1;j<=V[i].getOutsNum();j++) {
				System.out.print(V[i].getOuts(j).getName()+",");
			}
			System.out.println();
		}
		//while there is an "unvisited" v do dfs(v)	
		int i=0;
		while(i<numVertex) {
			for (i=1;i<=numVertex;i++) {
				isViisitedBySameLoop[i-1]=true;
				if(!V[i].isVisited()){ 
					ts.dfs(V[i]);
					}
				isViisitedBySameLoop[i-1]=false;
			}
		}
		//pop() until STACK=empty and write
		i=0;
		while(i<numVertex) {
			Vertex v=(Vertex) ts.getStk().pop(); 
			i++;
			System.out.println("Pops out "+v.getName()+" ");
		}
		
		System.out.flush();
		
	}
}
	
	
