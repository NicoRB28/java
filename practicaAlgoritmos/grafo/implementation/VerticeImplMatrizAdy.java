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
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public int getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}

	@Override
	public void setPosition(int pos) {
		// TODO Auto-generated method stub
		this.position = pos;
	}

	@Override
	public void conect(Vertice<T> vertice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconect(Vertice<T> vertice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Arista<T>> getAdjacents() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
