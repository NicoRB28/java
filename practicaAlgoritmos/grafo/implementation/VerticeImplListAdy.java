package practicaAlgoritmos.grafo.implementation;

import java.util.LinkedList;
import java.util.List;

import src.practicaAlgoritmos.grafo.infrastructure.Arista;
import src.practicaAlgoritmos.grafo.infrastructure.Vertice;

public class VerticeImplListAdy<T> implements Vertice<T> {
	
	private T value;
	private int position;
	private List<Arista<T>> adjacents;
	
	public VerticeImplListAdy(T value) {
		this.value = value;
		this.adjacents = new LinkedList<Arista<T>>();
	}
	
	@Override
	public T getValue() {
		return this.value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	@Override
	public int getPosition() {
		return this.position;
	}

	@Override
	public void setPosition(int pos) {
		this.position = pos;
	}

	@Override
	public void conect(Vertice<T> vertice) {
		this.conect(vertice, 1);
		
	}
	
	public void conect(Vertice<T> vertice, int p) {
		Arista<T> arista = getArista(vertice);
		if(arista == null) {
			Arista<T> a = new AristaImplementation<T>(vertice, p);
			adjacents.add(a);
		}		
	}
	
	private Arista<T> getArista(Vertice<T> vertice){
		return this.adjacents.stream()
					  .filter(arist -> arist.getDestinationVertex() == vertice)
					  .findFirst().orElse(null);
	}


	@Override
	public void disconect(Vertice<T> vertice) {
		Arista<T> arista = this.getArista(vertice);
		if(arista != null) {
			this.adjacents.remove(arista);
		}
	}

	@Override
	public List<Arista<T>> getAdjacents() {
		return this.adjacents;
	}
	
	public boolean isAdjacent(Vertice<T> vertice) {
		return this.adjacents.contains(this.getArista(vertice));
	}
	
	public int getWeight(Vertice<T> v) {
		Arista<T> arista = this.getArista(v);
		return (arista != null) ? arista.getWeight() : 0;
	}
	
}
