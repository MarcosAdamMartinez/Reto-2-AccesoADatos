package reto2.parte2;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import transparencias.Libro;

public class PruebaXStreamJSON {

	public static void main(String[] args) {
		try {
			Libro elquijote = new Libro("El Quijote","Miguel de Cervantes","Nisu",233,1605);
			Libro elproblemadelostrescuerpos = new Libro("El problema de los tres cuerpos","Cixin Liu","Nova",350,2021);
		
			XStream xstream1 = new XStream(new JettisonMappedXmlDriver());
			xstream1.addPermission(AnyTypePermission.ANY);
			
			List misLibros = new ArrayList<Libro>();
		
			misLibros.add(elquijote);
			misLibros.add(elproblemadelostrescuerpos);
		
			String json = xstream1.toXML(elproblemadelostrescuerpos);
			System.out.println("JSON generado:\n" + json);
		
			misLibros.add((Libro) xstream1.fromXML(json));
			
			System.out.println(misLibros.toString().replaceAll("\\]\\[","\n"));
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
}
