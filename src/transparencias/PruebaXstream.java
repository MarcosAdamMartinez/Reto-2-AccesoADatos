package transparencias;

import java.util.List;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class PruebaXstream {

	public static void main(String[] args) {
		try {
			Libro elquijote = new Libro("El Quijote","Miguel de Cervantes","Nisu",233,1605);
			Libro elproblemadelostrescuerpos = new Libro("El problema de los tres cuerpos","Cixin Liu","Nova",350,2021);
		
			XStream xstream1 = new XStream(new DomDriver());
			xstream1.addPermission(AnyTypePermission.ANY);
			
			List misLibros = new ArrayList<Libro>();
		
			misLibros.add(elquijote);
			misLibros.add(elproblemadelostrescuerpos);
		
			String xml = xstream1.toXML(elproblemadelostrescuerpos);
			//System.out.print(xml);
		
			/*String xml ="<transparencias.Libro>\n"
		 	+" <titulo>El problema de los tres cuerpos</titulo>\n"
		 	+" <autor>Cixin Liu</autor>\n"
		 	+" <editorial>Nova</editorial>\n"
		 	+" <pagina>350</pagina>\n"
		 	+" <AñoPublicacion>2021</AñoPublicacion>\n"
			+"</transparencias.Libro>";*/
			//misLibros= (List<Libro>) xstream1.fromXML(xml);
			misLibros.add((Libro) xstream1.fromXML(xml));
			/*Libro libroLeidoDelArchivo = (Libro) xstream1.fromXML(xml);
			System.out.println(libroLeidoDelArchivo);*/
			System.out.println(misLibros.toString().replaceAll("\\]\\[","\n"));
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
