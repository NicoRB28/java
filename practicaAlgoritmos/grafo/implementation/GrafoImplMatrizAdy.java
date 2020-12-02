package practicaAlgoritmos.grafo.implementation;

import java.util.LinkedList;
import java.util.List;

import src.practicaAlgoritmos.grafo.infrastructure.Arista;
import src.practicaAlgoritmos.grafo.infrastructure.Grafo;
import src.practicaAlgoritmos.grafo.infrastructure.Vertice;

public class GrafoImplMatrizAdy<T> implements Grafo<T> {
	private int maxVertices;
	private List<Vertice<T>> vertices;
	int[][] matrizAdy;
	
	public GrafoImplMatrizAdy(int maxVert) {
		this.maxVertices = maxVert;
		vertices = new LinkedList<Vertice<T>>();
		matrizAdy = new int[maxVertices][maxVertices];
		this.initializeMatriz(matrizAdy);
	}
	
	private void initializeMatriz(int[][] matriz) {
		for(int i = 0; i < maxVertices; i++) {
			for(int j = 0; j < maxVertices; i++) {
				matrizAdy[i][j] = 0;
			}
		}
		
	}

	@Override
	public void addVertex(Vertice<T> vertice) {
		// TODO Auto-generated method stub
		if(!vertices.contains(vertice)) {
			vertices.add(vertice);
			vertice.setPosition(vertices.indexOf(vertice));
		}
		
	}

	@Override
	public void eliminateVertex(Vertice<T> vertice) {
		// TODO Auto-generated method stub
		int index = vertice.getPosition();
		for(int fila = index; fila < vertices.size(); fila++) {
			matrizAdy[fila] = matrizAdy[fila+1];
		}
		for (int fila = 0; fila < vertices.size();fila++) {
			for(int col = index; col<vertices.size(); col++) {
				matrizAdy[fila][col] = matrizAdy[fila][col+1];
			}
		}
		vertices.remove(vertice);
	}

	@Override
	public void conect(Vertice<T> verticeOrigen, Vertice<T> verticeDestino) {
		// TODO Auto-generated method stub
		this.conectWithWeight(verticeOrigen, verticeDestino, 1);
		
	}

	@Override
	public void conectWithWeight(Vertice<T> verticeOrigen, Vertice<T> verticeDestino, int peso) {
		// TODO Auto-generated method stub
		matrizAdy[verticeOrigen.getPosition()][verticeDestino.getPosition()] = peso;
		
	}

	@Override
	public void disconect(Vertice<T> verticeOrigen, Vertice<T> verticeDestino) {
		// TODO Auto-generated method stub
		matrizAdy[verticeOrigen.getPosition()][verticeDestino.getPosition()] = 0;
	}

	@Override
	public boolean isAdjacent(Vertice<T> verticeOrigen, Vertice<T> verticeDestino) {
		// TODO Auto-generated method stub
		return matrizAdy[verticeOrigen.getPosition()][verticeDestino.getPosition()] > 0;
	}

	@Override
	public List<Vertice<T>> listOfVertex() {
		// TODO Auto-generated method stub
		return vertices;
	}

	@Override
	public List<Arista<T>> listOfAdjacents(Vertice<T> vertice) {
		// TODO Auto-generated method stub
		LinkedList<Arista<T>> listaAdyacentes = new LinkedList<Arista<T>>();
		int posicionVertice = vertice.getPosition();
		Arista<T> arista;
		for(int i = 0; i < vertices.size(); i++) {
			if(matrizAdy[posicionVertice][i] > 0) {
				arista = new AristaImplementation<T>(vertices.get(i), matrizAdy[posicionVertice][i]);
				listaAdyacentes.add(arista);
			}
		}
		
		return listaAdyacentes;
	}

	@Override
	public Vertice<T> getVertex(int nroVertice) {
		// TODO Auto-generated method stub
		return vertices.get(nroVertice);
	}

	@Override
	public int getWeight(Vertice<T> verticeOrigen, Vertice<T> verticeDestino) {
		// TODO Auto-generated method stub
		return matrizAdy[verticeOrigen.getPosition()][verticeDestino.getPosition()];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return vertices.isEmpty();
	}
	
	

}
