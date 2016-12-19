package dao;

import implementacion.Persona;
import interfaces.DAOPersona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class DAOPersonaImpl extends Conexion implements DAOPersona{

    @Override
    public void registrar(Persona per) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO Persona(nombre) VALUES(?)");
            st.setString(1, per.getNombre());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Persona per) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE persona SET nombre = ?  WHERE id = ?");
            st.setString(1, per.getNombre());
            st.setInt(2, per.getId());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Persona per) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM persona WHERE id = ?");
            st.setInt(1, per.getId());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally {
            this.cerrar();
        }
    }

    @Override
    public List<Persona> listar() throws Exception {
        List<Persona> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from persona");
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Persona per = new Persona();
                per.setId(rs.getInt("id"));
                per.setNombre(rs.getString("nombre"));
                lista.add(per);
            }
        } catch (Exception e) {
            throw e;
        }finally {
            this.cerrar();
        }
        return lista;
    }
    
}
