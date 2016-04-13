/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import modelo.Alumno;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import modelo.Usuario;

/**
 *
 * @author miguel
 */
public class ActualizarDatosAlumnoHelper {

    private Session session;

    public ActualizarDatosAlumnoHelper() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    /**
     * Método que se encarga de actualizar los datos de un alumno.
     * @param contrasenia
     */
    public void actualizaDatos(String correo, String contrasenia, String nombre, 
            String ap, String am, int cel, String ad, Date fecha) {
        try {
            Transaction tx = session.beginTransaction();
            Query p = session.getNamedQuery("BuscaPorCorreo").setString("correoUsuario", correo);
            Usuario u = (Usuario)p.uniqueResult();
            int id = u.getIdUsuario();
            Query q = session.getNamedQuery("BuscaAlumnoPorID").setString("idUsuario", Integer.toString(id));
            Alumno a = (Alumno)q.uniqueResult();
            u.setCorreoUsuario(correo);
            u.setContraseniaUsuario(contrasenia);
            u.setNombreUsuario(ap);
            u.setApellidoPaternoUsuario(ap);
            u.setApellidoMaternoUsuario(am);
            u.setTelefonoUsuario(cel);
            u.setAcercaDeUsuario(ad);
            session.persist(u);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
