import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface llenado{
	Scanner entrada = new Scanner(System.in);
	public static int validacion() {
		int r = 0;
		boolean e = false;
	
	do {
		try {	
			r = entrada.nextInt();
			
			
		} catch (java.util.InputMismatchException x) {
			System.out.println("Ups! el dato que intentas ingresar no es valido");
			entrada.nextLine();
			e=true;
		}
		if (r>0) {
			e=false;
		}else {
			System.out.println("Ingresa porfavor solo numeros mayores a 0");
			e=true;
		}
	}while(e);
	return r;
}
	public static byte validacion1() {
		return (byte)validacion();
	}
	public static String validacionC() {
		boolean e=false;
		String carrera;
		int c=0;
		do {
			if(c==0) {
				System.out.println("Ingrese la Carrera:");
			}
			c=c+1;
			carrera = entrada.nextLine().toUpperCase();
			if(carrera.contains("ISC")||carrera.contains("IIA")||carrera.contains("IM")||carrera.contains("LA")||carrera.contains("CP")){
				e=false;
				
			}else {
				if(c!=1) {
					System.out.println("Escata carrera no existe u ocurrio un erro intente de nuevo");
				}
				e=true;
			}
		}while (e);
		return carrera;
	}
	public static Calendar validacionF() {
		int fechass[]=new int[3];
		boolean e=false;
		do {
			e=false;
			System.out.println("Ingrese la fecha con el formato(dd/mm/aaaa):");
			String bombolby = entrada.nextLine();
			try {
				fechass[0]=Integer.parseInt(bombolby.substring(0,2));
				fechass[1]=Integer.parseInt(bombolby.substring(3,5))-1;
				fechass[2]=Integer.parseInt(bombolby.substring(6,10));
			} catch (Exception x) {
				System.out.println("Parece que hubo un error el formato es dd/mm/aaaa intente de nuevo");
				e=true;
			}
		}while(e);
		Calendar fecha = Calendar.getInstance();
		fecha.set(fechass[2], fechass[1], fechass[0]);
		return fecha;
	}
}


class Alumnos implements llenado {
	private String nombre;
	private byte edad;
	private String carreda;
	private Calendar fechaInscripsion;
	
	
	
	
	public Alumnos() {}
	public Alumnos(String nombre, byte edad, String carreda, Calendar fechaInscripcion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.carreda = carreda;
		this.fechaInscripsion = fechaInscripcion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte getEdad() {
		return edad;
	}
	public void setEdad(byte edad) {
		this.edad = edad;
	}
	public String getCarreda() {
		return carreda;
	}
	public void setCarreda(String carreda) {
		this.carreda = carreda;
	}
	public Calendar getFechaInscripsion() {
		return fechaInscripsion;
	}
	public void setFechaInscripsion(Calendar fechaInscripsion) {
		this.fechaInscripsion = fechaInscripsion;
	}
	public String toString() {
		return "Datos de Alumno [Nombre: " + nombre + ", Edad:" + edad + ", Carrera:" + carreda + ", Fecha de Inscripsion="
				+ fechaInscripsion.get(Calendar.DATE)+"/"+(fechaInscripsion.get(Calendar.MONTH)+1)+"/"+fechaInscripsion.get(Calendar.YEAR) + "]";
	}
}


class MapaAlumnos implements llenado{
	Scanner emtrada = new Scanner(System.in);
	
	private Map<Integer, Alumnos> mapAlu = new HashMap<Integer, Alumnos>();

	public MapaAlumnos(Map<Integer, Alumnos> mapAlu) {
		super();
		this.mapAlu = mapAlu;
	}
	public MapaAlumnos() {}
	
	public Map<Integer, Alumnos> getMapAlumnos() {
		return mapAlu;
	}
	public void setMapAlumnos(Map<Integer, Alumnos> mapAlu) {
		this.mapAlu = mapAlu;
	}
	
	public void llenarMapa(int c) {
		Map<Integer, Alumnos> mapAlu = new HashMap<Integer, Alumnos>();
		
		for (int i = 0; i < c; i=i+1) {
			System.out.println("=================================================================================");
			System.out.println("======= Alumno #"+(i+1)+" ==========");
			System.out.println("Ingrese el nombre:");
			String nombre = entrada.nextLine();
			
			System.out.println("Ingrese la edad:");
			byte edad;
			edad = llenado.validacion1();
			
			String carrera = llenado.validacionC();
			Calendar fechaInscripcion = llenado.validacionF();
			Alumnos a = new Alumnos(nombre, edad, carrera, fechaInscripcion);
			System.out.println(a);
			mapAlu.put(i,a);
		}
		
		this.setMapAlumnos(mapAlu);
		
	}
	
	public void vaciarMapa() {
		
		Map<Integer, Alumnos> voidd =new HashMap<Integer, Alumnos>();
		this.setMapAlumnos(voidd);
		
		System.out.println("La lista ha sido vaciada");
	}
	
	public void mostrarCarrera(String carrera) {
		
		System.out.println("La carrera : "+carrera);
		Map<Integer, Alumnos> mapAlu = this.getMapAlumnos();
		
		for(int i=0;i<mapAlu.size();i=i+1) {
			Alumnos alumnoT = mapAlu.get(i);
			
			if (alumnoT.getCarreda().contains(carrera)) {
				System.out.println(alumnoT);
			}
		}
	}
	
	public double calcularPromedioEdades() {
		
		Map<Integer, Alumnos> mapAlu = this.getMapAlumnos();
		double promedio=0;
		
		for(int i=0;i<mapAlu.size();i=i+1) {
			Alumnos AlumnoT = mapAlu.get(i);
			promedio = promedio +AlumnoT.getEdad();
		}
		promedio = (promedio/mapAlu.size());
		return promedio;
	}
	
	
	public void filtroFecha(Calendar fecha) {
		
		System.out.println("La fecha fecha:");
		Map<Integer, Alumnos> mapAlu = this.getMapAlumnos();
		
		for(int i=0;i<mapAlu.size();i=i+1) {
			Alumnos alumnoT = mapAlu.get(i);
			int alumnofech = alumnoT.getFechaInscripsion().compareTo(fecha);
			
			if (alumnofech==1) {
				System.out.println(alumnoT);
			}
			
		}
		
	}
}


public class PruebaAlumnosHashMap {

	public static void main(String[] args) {
	
		MapaAlumnos ma = new MapaAlumnos();
		Calendar fecha = Calendar.getInstance();
		
		
		//Detalle con el mes
		fecha.set(2016, 7, 10);
		
		ma.llenarMapa(5);
		ma.vaciarMapa();
		byte opcion = 0;
		byte opcionx2 = 0;
		
		
		
		do {
			System.out.println("Digite 1 para Llenar la lista");
			System.out.println("Digite 2 para Vaciar la  lista");
			System.out.println("Digite 3 para Mostrar los alumnos por su carrera");
			System.out.println("Digite 4 para Calcular el Promedio de edades");
			System.out.println("Digite 5 para Mostrar los alumnos que se inscribieron después de la fecha: 10/08/2016");
			System.out.println("Digite 6 para ***SALIR***");
			System.out.println("====================================================================================0");
			opcion = llenado.validacion1();
			switch (opcion) {
			case 1:
				System.out.println("cantidad de alumnos: ");
				int c = llenado.validacion();
				ma.llenarMapa(c);
				break;
			case 2:
				ma.vaciarMapa();
				break;
			case 3:
				String carrera="";
				do {
				System.out.println("Digite 1 para seleccionar ISC");
				System.out.println("Digite 2 para seleccionar IIA");
				System.out.println("Digite 3 para seleccionar IM");
				System.out.println("Digite 4 para seleccionar LA");
				System.out.println("Digite 5 para seleccionar CP");
				opcionx2 = llenado.validacion1();
				switch (opcionx2) {
				case 1:
					carrera="ISC";opcionx2=6;break;
				case 2:
					carrera="IIA";opcionx2=6;break;
				case 3:
					carrera="IM";opcionx2=6;break;
				case 4:
					carrera="LA";opcionx2=6;break;
				case 5:
					carrera="CP";opcionx2=6;break;
				default:
					System.out.println("Ups, el dato ingresado no es valido");
					opcionx2=7;
					break;
					}
				}while(opcionx2!=6);
				ma.mostrarCarrera(carrera);break;
			case 4:
				System.out.println("promedio de edades: "+ma.calcularPromedioEdades());break;
			case 5:
				ma.filtroFecha(fecha);break;
			case 6:break;
			default:
				System.out.println("Ups, el dato ingresado no es valido");break;
			}
			
		}while(opcion!=6);
		
		System.out.println("A salido del programa, gracias por Usarlo");		
		
		

	}

}
