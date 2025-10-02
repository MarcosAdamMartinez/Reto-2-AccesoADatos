package reto2.parte2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import transparencias.Libro;

public class PruebaXStreamJSON {

	public static void main(String[] args) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("libro.json")));
				BufferedReader br = new BufferedReader(new FileReader(new File("libro.json")));) {
			
			Libro elquijote = new Libro("El Quijote","Miguel de Cervantes","Nisu",233,1605);
			Libro elproblemadelostrescuerpos = new Libro("El problema de los tres cuerpos","Cixin Liu","Nova",350,2021);
		
			XStream xstream1 = new XStream(new JettisonMappedXmlDriver());
			xstream1.addPermission(AnyTypePermission.ANY);
			
			List misLibros = new ArrayList<Libro>();
			List misLibros2 = new ArrayList<Libro>();
			
			misLibros.add(elquijote);
			misLibros.add(elproblemadelostrescuerpos);
		
			String json = xstream1.toXML(elproblemadelostrescuerpos) +"\n"+ xstream1.toXML(elquijote);
			System.out.println("JSON generado:\n" + json+"\n\n");
		
			bw.write(json);
			bw.close();
			
			String linea;
			System.out.println("JSON leido:");
			while ((linea = br.readLine())!=null) {
				System.out.println(linea);
				Libro libro = (Libro) xstream1.fromXML(linea);
				
				misLibros2.add(libro);
			}
			
			System.out.println("\nLibros como objetos leidos:\n"+misLibros2.toString().replaceAll("\\]\\[","\n"));
			
		
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
}
