package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import negocios.Archivos;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long totalTiempo;
        long tiempoInicio;
		
        tiempoInicio = System.currentTimeMillis();
        
        Archivos arch = new Archivos();
        
        String RutaArchivo = "/home/ochacon/pan-plagiarism-corpus-2010/IndiceDoc.txt"; //RUTA SERVIDOR
        //String RutaArchivo = "C:/Users/oschacon/Desktop/IndiceDoc.txt"; //RUTA WINDOWS TRABAJO
        //String RutaArchivo = "/mnt/c/Users/oschacon/Desktop/IndiceDoc.txt"; //RUTA BASH WINDOWS TRABAJO
        //String RutaArchivo = "/Users/marcusfenix/Documents/IndiceDoc.txt"; //RUTA MAC
        File ArchivoIn = new File(RutaArchivo);
        
        if(ArchivoIn.exists() && ArchivoIn.isFile())
        {
        	String RutaArchivoDestino = "/home/ochacon/pan-plagiarism-corpus-2010/Objeto.obj";
        	File ArchivoOut = new File(RutaArchivoDestino);
        	if(ArchivoOut.exists())
        	{
        		//ArchivoOut.delete();
        	}
        	/*BufferedWriter bw;
			try {
				bw = new BufferedWriter(new FileWriter(ArchivoOut));
				//bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nombreArchivoDestino), "UTF8"));
				//bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nombreArchivo)));
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			arch.LeerArchivos(ArchivoIn);
        }
        else if(ArchivoIn.isDirectory())
        {
        	System.out.println("La ruta corresponde a un Directorio.");
        }
        else
        {
        	System.out.println("El archivo en la ruta especificada no existe.");
        }
        
        totalTiempo = System.currentTimeMillis() - tiempoInicio;
		
		System.out.println("Tiempo demorado: " + (float) totalTiempo/1000 + " Segundos.");
	}

}
