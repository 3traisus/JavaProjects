package Odyseo;

import java.io.BufferedReader;
import java.io.FileReader;

public class Txt {
	
	//Aqui lo unico que hacemos es cargar los archivos txt para que se puedan abrir
	
	private String texto;
	
	public Txt(String ruta) {
		try{
			//la clase BufeerReader no lee los saltos de linea ya que los procesa como si fueran una sola
			BufferedReader bf=new BufferedReader(new FileReader(ruta));
			String temp="";
			String input;
			while((input= bf.readLine())!=null ){
				this.texto+=input + "\n";
				
				
			}
			//this.texto=temp;
		}catch(Exception e)
		{ //si se intenta abrir un archivo que no es de la extencion que nosotros permitimios arrojara el mensaje
			this.texto="El archivo de es de la extencion 'BSO' o 'TXT'";
		}
		
	}
	
	//ya si el archivo es de nuestar extencion permitida pues lo abrira
	public String getTexto(){
		return this.texto;
	}

}
