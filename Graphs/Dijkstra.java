import java.util.*;

public class Dijkstra extends WeightedGraph{

	private static WeightedGraph map;

	public static void main(String[] args){

		WeightedGraph map = new WeightedGraph();
		map.addVertex("New York City");
		map.addVertex("Long Island");
		map.addVertex("Albany");
		map.addVertex("Rochester");
		map.addVertex("New Jersey City");
		map.addEdge("New York City","Long Island",2);
		map.addEdge("New York City","Albany",4);
		map.addEdge("New York City","New Jersey City",4);
		map.addEdge("Albany","Rochester",5);

		System.out.println(map.toString());
		List<Edge> nyNeighbors = map.getAdjVertices("New York City");
		map.removeEdge(nyNeighbors.get(0));
		System.out.println(map.toString());
	}

	//TODO: implement Dijkstra
	public static void Dijkstra(WeightedGraph graph){

		

	}

}
