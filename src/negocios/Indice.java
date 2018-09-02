package negocios;

import java.util.Map;

public class Indice {
	
	private String palabra;
	private Map<Integer, Integer> docFreq;
	
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	public Map<Integer, Integer> getDocFreq() {
		return docFreq;
	}
	public void setDocFreq(Map<Integer, Integer> docFreq) {
		this.docFreq = docFreq;
	}
	
	

}
