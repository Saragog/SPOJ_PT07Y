import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class IsTree {

	/*
	You are given an unweighted, undirected graph. Write a program to check if it's a tree topology.

	Input
	The first line of the input file contains two integers N and M --- number of nodes and number of edges in the graph (0 < N <= 10000, 0 <= M <= 20000). Next M lines contain M edges of that graph --- Each line contains a pair (u, v) means there is an edge between node u and node v (1 <= u,v <= N).

	Output
	Print YES if the given graph is a tree, otherwise print NO.

	Example
	Input:
	3 2
	1 2
	2 3

	Output:
	YES
	*/
	
	private boolean[] usedNodes;
	private Arc[] arcs;
	private ArrayList<Arc> allArcs;
	private LinkedList<Arc> availableArcs;
	private int nodeNumber;
	private int arcNumber;
	//private // TODO
	
	private static class Arc{
		
		public int node1;
		public int node2;
		public boolean wasUsed;
		
		public Arc(int node1, int node2)
		{
			this.node1 = node1;
			this.node2 = node2;
			this.wasUsed = false;
		}
	}
	
	private boolean checkIfAppropriateNumberOfArcsForTree()
	{
		if (arcNumber == nodeNumber - 1) return true;
		else return false;
	}
	
	private void addExistingArc(int node1, int node2)
	{
		allArcs.add(new Arc(node1, node2));
		return;
	}

	private void addAvailableArc(Arc a)
	{
		availableArcs.add(a);
	}
	
	private void prepareNodes(int nodeNumber)
	{
		usedNodes = new boolean[nodeNumber];
		for (int step = 0; step < nodeNumber; step++)
			usedNodes[step] = false;
		return;
	}
	
	private void readAllInput()
	{
		Scanner input = new Scanner(System.in);
		nodeNumber = input.nextInt();
		arcNumber = input.nextInt();
		prepareNodes(nodeNumber);
		
		checkIfAppropriateNumberOfArcsForTree();
		allArcs = new ArrayList<Arc>(arcNumber);
		
		for (int step = 0; step < arcNumber; step++)
			addExistingArc(input.nextInt(), input.nextInt());
		return;
	}
	
	private void updateAvailableArcs(int actualNode)
	{
		int node1, node2;
		Arc actualArc;
		for (int actualArcIndex = 0; actualArcIndex < arcNumber; actualArcIndex++)
		{
			actualArc = allArcs.get(actualArcIndex);
			node1 = allArcs.get(actualArcIndex).node1;
			node2 = allArcs.get(actualArcIndex).node2;
			
			if (usedNodes[node1-1] || usedNodes[node2-1]) // Oznacza, ze ktorys z wierzcholkow juz byl wykorzystany a wiec jest zapetlenie wiec nie jest to drzewo
			{
				System.out.println("NO");
				return;
			}
			else
				availableArcs.add(actualArc);
		}
		
		return;
	}
	
	private boolean checkIfAllNodesWereUsed()
	{
		for (int actualNodeIndex = 0; actualNodeIndex < nodeNumber; actualNodeIndex++)
			if (!usedNodes[actualNodeIndex])
				return false;
		return true;
	}
	
	private void performCalculations()
	{
		int actualNode = 1;
		updateAvailableArcs(actualNode);
		usedNodes[0] = true;
		while(!availableArcs.isEmpty())
		{
			
			// TODO usuwanie pojedynczego noda
		}
		if(checkIfAllNodesWereUsed()) System.out.println("YES");
		else System.out.println("NO");
	}
	
	public static void main(String[] args) {
		IsTree program = new IsTree();
		program.readAllInput();
		program.performCalculations();		
	}

}
