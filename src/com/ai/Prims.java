package com.ai;

import java.util.*;

class Prims {
    private static int vertices  = 5;
    
    public static void main (String[] args) {
    	//random integer code is for DEBUGGING ONLY
    	//Random rand = new Random();
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter Numbers, pressing enter after each new number: ");
        int graph[][] = new int[vertices][vertices];
        for(int i = 0; i<graph.length;i++) {
			for(int j = 0; j<graph[i].length; j++) {
				//graph[i][j]=rand.nextInt(10);
				graph[i][j]=scan.nextInt();
			}
		}
        primAlgo(graph);
    }
    public static int findMinimumEdge(int minVert[], Boolean visited[]) {
        int minimum = Integer.MAX_VALUE;
        int index = - 1;

        for (int i = 0; i < vertices; i++)
            if (!visited[i] && minVert[i] < minimum)
            {
                minimum = minVert[i];
                index = i;
            }
        return index;
    }
    public static void printTree(int tree[], int graph[][]) {
        System.out.println("Edges:	Cost:");
        for (int i = 1; i<vertices; i++) {
            System.out.println(tree[i] + "-" + i + "	" + graph[i][tree[i]]);
        }
        System.out.println("Adjecenty Matrix: ");
        int[][] adMat=new int[vertices][vertices];
        for (int i = 1; i<vertices; i++){
            adMat[tree[i]][i] = 1;
            adMat[i][tree[i]] = 1;
        }
        System.out.print("  ");
        for(int vert=1; vert<=vertices; vert++) {
        	System.out.print(vert + " ");
        }
        System.out.println();
        for(int i = 0; i<vertices;i++) {
        	System.out.print(i+1 + " ");
			for(int j = 0; j<vertices; j++) {
				System.out.print(adMat[i][j] + " ");
			}
			System.out.println();
		}
        
    }
    public static void primAlgo(int graph[][])
    {
        int minST[] = new int[vertices];
        int minVert[] = new int [vertices];
        Boolean visited[] = new Boolean[vertices];
        for (int i = 0; i < vertices; i++)
        {
            minVert[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        minVert[0] = 0;
        minST[0] = -1;

        for (int count = 0; count < vertices - 1; count++)
        {
            int i = findMinimumEdge(minVert, visited);
            visited[i] = true;
            for (int j = 0; j < vertices; j++)
            {
                if (graph[i][j] != 0 && !visited[j] && graph[i][j] < minVert[j])
                {
                    minST[j] = i;
                    minVert[j] = graph[i][j];
                }
            }
        }
        printTree(minST, graph);
    }
}
