public class ListaLibros
{
   
    Libro primero;
    /**
     * Constructor for objects of class ListaNodos
     */
    public ListaLibros()
    {
        primero = null;
    }
    
    // Incluye un nuevo libro en la lista
    public void pon(Libro valor) {
    	if(primero==null)
    	{
            primero = valor;
    	}
    	else
    	{
        	valor.siguiente = primero;
            primero = valor;
    	}
    }
    
	public boolean estaVacia(){
       return ( primero == null );       
    }
    
    // Devuelve un libro que es eliminado de la lista o null si no exite
    public Libro quitar ( int id ) {
    	Libro aux;
    	Libro aux1;
    	aux = primero;
    	aux1 = primero.siguiente;
    	if (aux.id==id)
    	{
    		primero=primero.siguiente;
    		return aux;
    	}
    	else
    	{
    		while(aux1!=null)
        	{
        		if (aux1.id==id)
        		{
        			aux.siguiente = aux1.siguiente;
        			return aux1;
        		}
        		aux = aux1;
        		aux1 = aux1.siguiente;
        	}
    	}
        return null;
    }
   
    // Devuelve el id del libro o -1 si no esta
    public int buscarId ( String titulo ){
    	Libro aux;
    	aux = primero;
    	while(aux!=null)
    	{
    		if(aux.titulo.equals(titulo))
    		{
    			return aux.id;
    		}
    		aux = aux.siguiente;
    	}
       return -1;
   }
    // Muestra los libros almacenados
    public void verCatalogo (){
    	Libro aux;
    	aux = primero;
    	while(aux!=null)
    	{
    		System.out.println(aux.toString());
    		aux = aux.siguiente;
    	}	
    }
}