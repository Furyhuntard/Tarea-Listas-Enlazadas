import java.util.Scanner;
import java.util.Scanner;
public class Biblioteca
{
   public static void main ( String argv[]){
       
       ListaLibros disponibles = new ListaLibros();
       ListaLibros prestados =   new ListaLibros();
       Scanner sc = new Scanner(System.in);
       
       // Rellenar las listas con valores de pruebasda

       
       
       disponibles.pon(new Libro(25,"El Buscón","Quevedo",Genero.NOVELA,1997));
       disponibles.pon(new Libro(1,"El señor de los Anillos","J.R.R Tolkien",Genero.NOVELA,1954));
       disponibles.pon(new Libro(2,"Origen","Dan Brown",Genero.NOVELA,2017));
       disponibles.pon(new Libro(3,"Deja en paz al diablo","John Verdon",Genero.NOVELA,2012));

   
       prestados.pon( new Libro(30,"Harry Potter I", "J. K. Rowling", Genero.NOVELA,1998));
       prestados.pon( new Libro(4,"Sé lo que estas pensando", "John Verdon", Genero.NOVELA,2010));
       prestados.pon( new Libro(5,"Mortadelo y Filemón", "Francisco Ibañez", Genero.OTRO,1998));


       // Muestro ambas listas
       System.out.println("Libros Disponibles:");
       System.out.println("--------------------");
       disponibles.verCatalogo();
       
       System.out.println(" ");
       
       System.out.println("Libros Prestados:");
       System.out.println("-----------------");
       prestados.verCatalogo();
       System.out.println(" ");
       
       
       // Pedir datos al usuarios y probar el método prestarLibro
       System.out.println("Prestamo de libros:");
       System.out.println("¿Que libro desea?:");
       String titulo = sc.nextLine();
       int resu = prestarLibro(titulo,prestados,disponibles);
       
       switch ( resu )
       {
          case  0:  System.out.println("El libro no está en el catalogo");System.out.println("");break;
          case -1:  System.out.println("El libro está prestado");System.out.println(""); break;
          case  1:  System.out.println("Su pestamo ha sido anotado");System.out.println(""); break;
       }
        
        
       // Muestro ambas listas de nuevo
       System.out.println("Libros Disponibles:");
       System.out.println("-------------------");
       disponibles.verCatalogo();
       
       System.out.println(" ");
       
       System.out.println("Libros Prestados:");
       System.out.println("-----------------");
       prestados.verCatalogo();
       System.out.println(" ");
                
    }
   
   /*   Realiza el prestamos pasado un libro de la lista de libros disponibles a la lista de libros prestados
    * Devuelve:
    *  0 si no existe el libro en niguna de la listas
    *  1 Si puede prestarlo, el libro pasa de ldisponibles a lprestados
    * -1 Si ya esta prestado.
    */
   public static int prestarLibro ( String titulo, ListaLibros lprestados, ListaLibros ldisponibles){
   
      int idprestado    = lprestados.buscarId(titulo);
      int iddisponible  = ldisponibles.buscarId(titulo);
      
      if ( idprestado == -1 && iddisponible == -1) return 0; // No esta en catalogo
      if ( idprestado !=  -1)  return -1; // Esta prestado
     	  Libro libroaPrestar = ldisponibles.quitar(iddisponible);
          lprestados.pon(libroaPrestar);
          return 1;
    }
 }
