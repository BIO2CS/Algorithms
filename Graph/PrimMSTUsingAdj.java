package Graph;

import java.util.*;

public class PrimMSTUsingAdj {

    private boolean[] visited;
    private int[] pathTo;
    private double[] distTo;
    private PrimMinHeap heap;
    
    public PrimMSTUsingAdj(WeightedEdgeGraph g) {
        visited = new boolean[g.V()];
        pathTo = new int[g.V()];
        distTo = new double[g.V()];
        PrimNode[] nodes = new PrimNode[g.V()];
        for (int v = 1; v < g.V(); v++) {
            distTo[v] = Double.MAX_VALUE;
            nodes[v] = new PrimNode(v, distTo[v]);
        }
        distTo[0] = 0.0;
        nodes[0] = new PrimNode(0, distTo[0]);
        heap = new PrimMinHeap(nodes);       
        mstUsingAdj(g);
    }
    
    public void mstUsingAdj(WeightedEdgeGraph g) {
        while (!heap.isEmpty()) {
            PrimNode front = heap.extractMin();
            visited[front.v] = true;
            System.out.println("Pulling from queue vertex is " + front.v + " weight is " + front.weight);
            /*Iterable<WeightedEdge> list = g.adj(front.v);
            for (WeightedEdge edge : list) {
                int one = edge.either(), other = edge.other(one);
                System.out.println("\t\t" + one + "->" + other + ": " + edge.weight());
            }*/
            for (WeightedEdge e : g.adj(front.v)) {
                int w = e.other(front.v);
                if (visited[w]) continue;
                if (heap.isInMinHeap(w) && e.weight() < distTo[w]) {
                    distTo[w] = e.weight();
                    pathTo[w] = front.v;
                    heap.decreaseWeight(w, e.weight());
                }
            }
          /*  for (PrimNode n : queue) {
                System.out.println("\t" + n.v + ": " + n.weight + "\t\t");
            }*/
        }
    }
    
    public void printMST() {
        double totalWeight = 0;
        for (int v = 1; v < pathTo.length; v++) {
            totalWeight += distTo[v];
            System.out.format("%d - %d: %.0f%n", pathTo[v], v, distTo[v]);
        }
        System.out.format("Total Weight in MST is: %.0f%n", totalWeight);
    }
}

class PrimNode {
    int v;
    double weight;
    
    PrimNode(int v, double weight) {
        this.v = v;
        this.weight = weight;
    }
}

class PrimMinHeap {
    int size;
    int capacity;
    PrimNode[] array;
    int[] position;  //position[vertexNumber] = position in the array;
    
    public PrimMinHeap(PrimNode[] nodes) {        
        this.size = this.capacity = nodes.length;
        array = nodes;
        position = new int[size];
        for (int i = 0; i < size; i++) {
            position[array[i].v] = i;
        }
        buildHeap();
    }
    
    public void buildHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }
    
    public PrimNode extractMin() {
        PrimNode smallest = array[0], last = array[size - 1];
        swapNodes(0, size - 1);
        position[smallest.v] = size - 1;
        position[last.v] = 0;
        size--;
        heapify(0);
        return smallest;
    }
    
    public void decreaseWeight(int vertexNumber, double newWeight) {
        int index = position[vertexNumber];
        PrimNode node = array[index];
        node.weight = newWeight;
        while(index > 0 && array[index].weight < array[(index - 1) / 2].weight) {
            PrimNode child = array[index], parent = array[(index - 1) / 2];
            swapNodes(index, (index - 1) / 2);
            position[child.v] = (index - 1) / 2;
            position[parent.v] = index;
            index = (index - 1) / 2;
        }
    }
    
    public boolean isInMinHeap(int vertex) {
        return position[vertex] < size;
    }
    
    private void heapify(int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int smallestIndex = i;
        if (left < size && array[left].weight < array[smallestIndex].weight) {
            smallestIndex = left;
        }
        if (right < size && array[right].weight < array[smallestIndex].weight) {
            smallestIndex = right;
        }
        if (smallestIndex != i) {
            PrimNode child = array[smallestIndex], parent = array[i];
            swapNodes(i, smallestIndex);
            position[child.v] = i;
            position[parent.v] = smallestIndex;
            heapify(smallestIndex);
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    private void swapNodes(int i, int j) {
        PrimNode temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}