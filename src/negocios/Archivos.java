package negocios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Archivos {

	public void LeerArchivos(File ArchivoIn)
	{
		Map<String, Map<Integer, Integer>> MapaIndice = new HashMap<String, Map<Integer, Integer>>();
		List<Indice> listaInd = new ArrayList<Indice>();
		String Linea;
		try {
			BufferedReader br = new BufferedReader(new FileReader(ArchivoIn));
			while((Linea=br.readLine())!=null)
			{
				Indice objInd = new Indice();
				List<String> ArrayString = new ArrayList<String>();
				Map<Integer,Integer> MapaFrecuencias = new HashMap<Integer, Integer>();
				//String[] ArrayString = Linea.trim().split("\\s+");
				ArrayString = Arrays.asList(Linea.trim().split("\\s+"));
				objInd.setPalabra(ArrayString.get(0).trim());
				for(int i = 1; i < ArrayString.size(); i++)
				{
					//String[] fIn = ArrayString[i].trim().split(",");
					String[] fIn = ArrayString.get(i).trim().split(",");
					MapaFrecuencias.put(Integer.parseInt(fIn[0].trim()), Integer.parseInt(fIn[1].trim()));
				}
				if(MapaFrecuencias.size() > 0)
				{
					objInd.setDocFreq(MapaFrecuencias);
					listaInd.add(objInd);
				}				
			}
			br.close();		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		int j = 0;
		if(listaInd.size() > 0)
		{
			for(Indice indIt : listaInd)
			{
				System.out.println("Palabra: "+indIt.getPalabra());
				for(Map.Entry<Integer, Integer> aux : indIt.getDocFreq().entrySet())
				{
					System.out.println("Doc: "+aux.getKey()+ ", Freq: "+aux.getValue());
				}
				if(j > 4)
				{
					break;
				}
				j++;
			}
			//this.GuardarArchivoObjeto(MapaIndice, ArchivoOut);
		}
	}
	
	public void GuardarArchivoObjeto(Map<String, Map<Integer, Integer>> MapaObjeto, File ArchivoOut)
	{
		try {
			ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(ArchivoOut));
			oos.writeObject(MapaObjeto);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
