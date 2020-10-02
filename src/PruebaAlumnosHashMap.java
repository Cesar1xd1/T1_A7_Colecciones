import java.util.Scanner;

class Alumnos {
	private String nombre;
	private byte edad;
	private String carreda;
	private String fechaInscripsion;
	
	public Alumnos() {}
	public Alumnos(String nombre, byte edad, String carreda, String fechaInscripsion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.carreda = carreda;
		this.fechaInscripsion = fechaInscripsion;
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
	public String getFechaInscripsion() {
		return fechaInscripsion;
	}
	public void setFechaInscripsion(String fechaInscripsion) {
		this.fechaInscripsion = fechaInscripsion;
	}
	
	public void llenarObjeto(Alumnos a) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingresa el nombre del alumno:");
		a.setNombre(entrada.nextLine());
		System.out.println("Ingresa la edad del alumno:");
		a.setEdad(entrada.nextByte());
		System.out.println("Ingresa la carrera del alumno:");
		System.out.println("Indique ISC,IIA,IM,LA,CP");
		a.setCarreda(entrada.next());
		System.out.println("Ingresa la fecha de inscripcion del alumno con le formato (dd/mm/aaaa)");
		a.setFechaInscripsion(entrada.nextLine());
		
		
		
		
		
		
		
	}
	
	
	
}



public class PruebaAlumnosHashMap {

	public static void main(String[] args) {
	

	}

}
