package practicaAlgoritmos.grafo.implementation;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

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
		IntStream.rangeClosed(0, this.maxVertices)
				 .forEach(i -> IntStream.rangeClosed(0, this.maxVertices)
						 				.forEach(j -> this.matrizAdy[i][j]=0));
		
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
		int index = vertice.getPosition();
		
		IntStream.range(index, this.vertices.size())
				 .forEach(fila -> this.matrizAdy[fila] = this.matrizAdy[fila+1]);
		
		IntStream.range(0,this.vertices.size())
		 		 .forEach(fila -> IntStream.range(fila, this.vertices.size())
				 .forEach(col -> this.matrizAdy[fila][col]= this.matrizAdy[fila][col+1]));
		
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
		LinkedList<Arista<T>> listaAdyacentes = new LinkedList<Arista<T>>();
		int posicionVertice = vertice.getPosition();
		
		IntStream.range(0, this.vertices.size())
				 .filter(index -> this.matrizAdy[posicionVertice][index] > 0)
				 .mapToObj(index -> new AristaImplementation<T>(this.vertices.get(index),this.matrizAdy[posicionVertice][index]))
				 .map(ari -> listaAdyacentes.add(ari));
		
		return listaAdyacentes;
	}

	@Override
	public Vertice<T> getVertex(int nroVertice) {
		return vertices.get(nroVertice);
	}

	@Override
	public int getWeight(Vertice<T> verticeOrigen, Vertice<T> verticeDestino) {
		return matrizAdy[verticeOrigen.getPosition()][verticeDestino.getPosition()];
	}

	@Override
	public boolean isEmpty() {
		return vertices.isEmpty();
	}
	
	

}
