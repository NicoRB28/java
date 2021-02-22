package practicaAlgoritmos.grafo.implementation;

import java.util.List;

import src.practicaAlgoritmos.grafo.infrastructure.Arista;
import src.practicaAlgoritmos.grafo.infrastructure.Vertice;

public class VerticeImplMatrizAdy<T> implements Vertice<T> {
	private T value;
	private int position;
	
	public VerticeImplMatrizAdy(T value) {
		this.value = value;
	}

	@Override
	public T getValue() {
		return this.value;
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
		
		
	}

	@Override
	public void disconect(Vertice<T> vertice) {
		
		
	}

	@Override
	public List<Arista<T>> getAdjacents() {
		
		return null;
	}
	
	
}
