import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphRunTimes {

    public static void main(String[] args){
        dfsCalculations();
        bfsCalc();
    }

    private static void bfsCalc() {

        ArrayList durationlist= new ArrayList<Long>();
        for (int i=1; i<15; i++){
            int size = (int) Math.pow(2, i);

            BFSSearch bfsSearch = new BFSSearch( size);
            boolean[] visited = new boolean[size];
            for(int j=0; j < size; j++)
                visited[j] = false;
            long starttime = System.currentTimeMillis();

            bfsSearch.search(0);
            long endtime = System.currentTimeMillis();

            durationlist.add(endtime - starttime);
            System.out.println("BFS" + durationlist);


        }
        System.out.println("BFS" + durationlist);
    }

    private static void dfsCalculations() {

        ArrayList durationlist= new ArrayList<Long>();
        for (int i=1; i< 15; i++){
            int size = (int) Math.pow(2, i);
            System.out.println("sze "+ size);

            DFSGraph dfsGraph = new DFSGraph( size);
            boolean[] visited = new boolean[size];
            for(int j=0; j < size; j++)
                visited[j] = false;
            long starttime = System.currentTimeMillis();
            System.out.println("starting index : "+i);

            dfsGraph.search(0, visited);
            long endtime = System.currentTimeMillis();

            durationlist.add(endtime - starttime);
            System.out.println("DFS"+durationlist);


        }
        System.out.println("--------------------------");

        System.out.println("DFS" + durationlist);
    }
    public static class DFSGraph {
        int size;
        int[][] adj;
        public DFSGraph(int size) {
            this.size = size;
            adj = new int[size][size];

            for(int i =0; i< size; i++)
                for(int j=0; j< size ; j++)
                    adj[i][j] = 1;

            for(int i =0; i< size; i++)
                adj[i][i] = 0;

        }

        public void search(int start, boolean[] visited){
            visited[start] = true;

            for( int i=0; i<size; i++)
                if( (adj[start][i] == 1 ) && (!visited[i])) {
                    search(i, visited);
                    System.out.println(String.format("Visitd %d,%d", start, i));
                }
        }
    }


    public static class BFSSearch {
        int size;
        int[][] adj;


        public BFSSearch(int size) {
            this.size = size;
            adj = new int[size][size];

            for(int i =0; i< size; i++)
                for(int j=0; j< size ; j++)
                    adj[i][j] = 1;

            for(int i =0; i< size; i++)
                adj[i][i] = 0;

        }

        public void search(int start){
            boolean[] visited = new boolean[size];
            for(int i=0; i< size; i++)
                visited[i] = false;
            Queue q = new LinkedList<Integer>();
            q.add(start);

            visited[start] = true;

            while (!q.isEmpty()){
                int vis = (int) q.peek();

                q.remove();

                for ( int i = 0; i< size; i++){
                    if( adj[vis][i] == 1 && !visited[i]){
                        q.add(i);
                        visited[i] = true;
                    }
                }

            }




        }

    }

}
