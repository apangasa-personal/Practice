package scaler.Graph4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class EdgeInMST {
    public static void main(String[] args) {
        int A = 52;
        int[][] B = {
                {44, 50, 42},
                {23, 26, 468},
                {20, 45, 335},
                {4, 26, 501},
                {12, 33, 170},
                {9, 41, 725},
                {30, 51, 479},
                {2, 26, 359},
                {2, 23, 963},
                {16, 18, 465},
                {32, 51, 706},
                {30, 49, 146},
                {46, 52, 282},
                {13, 31, 828},
                {2, 37, 962},
                {11, 44, 492},
                {22, 23, 996},
                {31, 40, 943},
                {1, 5, 828},
                {13, 44, 437},
                {6, 13, 392},
                {23, 37, 605},
                {29, 37, 903},
                {8, 43, 154},
                {13, 37, 293},
                {30, 36, 383},
                {11, 39, 422},
                {11, 42, 717},
                {29, 32, 719},
                {28, 32, 896},
                {26, 37, 448},
                {28, 45, 727},
                {7, 31, 772},
                {15, 46, 539},
                {31, 51, 870},
                {15, 19, 913},
                {22, 36, 668},
                {6, 47, 300},
                {10, 48, 36},
                {19, 27, 895},
                {2, 19, 704},
                {11, 40, 812},
                {33, 35, 323},
                {8, 38, 334},
                {38, 43, 674},
                {3, 36, 665},
                {1, 16, 142},
                {22, 32, 712},
                {18, 20, 254},
                {31, 43, 869},
                {18, 44, 548},
                {5, 33, 645},
                {21, 42, 663},
                {17, 29, 758},
                {2, 51, 38},
                {12, 19, 860},
                {13, 47, 724},
                {18, 38, 742},
                {22, 27, 530},
                {15, 21, 779},
                {10, 31, 317},
                {16, 20, 36},
                {44, 45, 191},
                {2, 11, 843},
                {7, 36, 289},
                {8, 47, 107},
                {25, 38, 41},
                {10, 36, 943},
                {1, 41, 265},
                {5, 49, 649},
                {11, 38, 447},
                {32, 40, 806},
                {32, 37, 891},
                {17, 45, 730},
                {6, 37, 371},
                {2, 10, 351},
                {13, 48, 7},
                {3, 26, 102},
                {5, 9, 394},
                {43, 50, 549},
                {17, 52, 630},
                {2, 42, 624},
                {10, 27, 85},
                {24, 37, 955},
                {37, 51, 757},
                {10, 29, 841},
                {24, 46, 967},
                {38, 46, 377},
                {46, 51, 932},
                {14, 44, 309},
                {6, 39, 945},
                {31, 35, 440},
                {39, 41, 627},
                {2, 15, 324},
                {3, 13, 538},
                {16, 27, 539},
                {20, 23, 119},
                {16, 28, 83},
                {12, 20, 930},
                {3, 4, 542},
                {26, 35, 834},
                {12, 50, 116},
                {35, 41, 640},
                {21, 30, 659},
                {27, 52, 705},
                {2, 45, 931},
                {23, 45, 978},
                {14, 51, 307}
                    };
        System.out.println(Arrays.toString(solve(A,B)));
    }

    public static class GraphEdge{
        public int source;
        public int dest;
        public int weight;
        public int index;

        public GraphEdge(int source, int dest, int weight, int index) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
            this.index = index;
        }
    }

    public static class CustomComparator implements Comparator<GraphEdge> {
        @Override
        public int compare(GraphEdge a, GraphEdge b){
            if(a.weight < b.weight)
                return -1;
            return 1;
        }
    }

    public static int[] solve(int A, int[][] B) {
        PriorityQueue<GraphEdge> edges = new PriorityQueue<>(new CustomComparator());
        int[] result = new int[B.length];
        for (int i = 0; i < B.length; i++)
            edges.add(new GraphEdge(B[i][0], B[i][1], B[i][2], i));

        int[] parents = new int[A + 1];
        for (int i = 1; i < parents.length; i++)
            parents[i] = i;

        while (edges.size() > 0) {
            GraphEdge currentEdge;
            ArrayList<Integer[]> validPC = new ArrayList<>();
            do {
                currentEdge = edges.poll();
                Integer[] resultOfCheckParent = checkParent(currentEdge, parents);
                if (resultOfCheckParent != null) {
                    result[currentEdge.index] = 1;
                    validPC.add(resultOfCheckParent);
                }
            }
            while (edges.size() > 0 && currentEdge.weight == edges.peek().weight);
            for(Integer[] node : validPC){
                setParent(node, parents);
            }
        }
        return result;
    }

    public static int getParent(int node, int[] parents){
        while(parents[node] != node)
            node = parents[node];

        return node;
    }

    public static void setParent(Integer[] nodes, int[] parents){
        parents[nodes[0]] = nodes[1];
    }

    private static Integer[] checkParent(GraphEdge currentEdge, int[] parents) {
        if(getParent(currentEdge.source, parents) == getParent(currentEdge.dest, parents))
            return null;

        int parentSource =getParent(currentEdge.source, parents), parentDest = getParent(currentEdge.dest, parents);

        if(parentSource == parentDest){
            return null;
        }
        if(currentEdge.dest > parentSource)
            return new Integer[]{currentEdge.dest, parentSource};
        else
            return new Integer[]{parentSource, currentEdge.dest};
    }

}
