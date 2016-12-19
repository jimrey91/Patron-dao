package interfaces;

import implementacion.Persona;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface DAOPersona {
    
    public void registrar(Persona per) throws Exception;
    public void modificar(Persona per) throws Exception;
    public void eliminar (Persona per) throws Exception;
    public List<Persona> listar() throws Exception;
}
