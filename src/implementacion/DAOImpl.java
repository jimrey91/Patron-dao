package implementacion;

import dao.DAOPersonaImpl;
import interfaces.DAOPersona;

/**
 *
 * @author Daniel
 */
public class DAOImpl {
    
    public static void main(String[] args) {
        Persona per = new Persona();
        //per.setId(1);
        per.setNombre("victor");
        
        try {
            DAOPersona dao = new DAOPersonaImpl();
            for (Persona p : dao.listar()) {
                System.out.println(p.getNombre());
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
