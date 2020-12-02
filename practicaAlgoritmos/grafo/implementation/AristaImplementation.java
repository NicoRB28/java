package practicaAlgoritmos.grafo.implementation;

import src.practicaAlgoritmos.grafo.infrastructure.Arista;
import src.practicaAlgoritmos.grafo.infrastructure.Vertice;

public class AristaImplementation<T> implements Arista<T> {

	private Vertice<T> destination;
	private int weight;
	
	public AristaImplementation(Vertice<T> vertex, int weight) {
		this.destination = vertex;
		this.weight = weight;
	}
	
	@Override
	public Vertice<T> getDestinationVertex() {
		return this.destination;
	}

	@Override
	public int getWeight() {
		return this.weight;
	}
	
}
