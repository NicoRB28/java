package practicaAlgoritmos.grafo.implementation;

import practicaAlgoritmos.grafo.infrastructure.Arista;
import practicaAlgoritmos.grafo.infrastructure.Vertice;

public class AristaImplementation<T> implements Arista<T> {

	private Vertice<T> destination;
	private int weight;
	
	public AristaImplementation(Vertice<T> vertex, int weight) {
		this.destination = vertex;
		this.weight = weight;
	}
	
	@Override
	public Vertice<T> getDestinationVertex() {
		// TODO Auto-generated method stub
		return this.destination;
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}
	
}
