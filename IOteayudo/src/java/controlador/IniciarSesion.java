/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import logica.IniciarSesionHelper;


/**
 *
 * @author yosh
 */
@ManagedBean
@RequestScoped 
public class IniciarSesion {
    private String correo;
    private String contrasenia;
    private final HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
    private final FacesContext faceContext; // Obtiene información de la aplicación
    private FacesMessage message; // Permite el envio de mensajes entre el bean y la vista
    private IniciarSesionHelper helper;

    public IniciarSesion() {faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest)faceContext.getExternalContext().getRequest();
        helper = new IniciarSesionHelper();
    }

    public String iniciarSesion() {
        modelo.Usuario usuario = helper.getLoginPorCorreo(getCorreo());
        if (usuario != null) {
            if (getContrasenia().equals(usuario.getContraseniaUsuario())) {
                httpServletRequest.getSession().setAttribute("sessionUsuario", correo);
                boolean esAlumno = helper.esAlumno(usuario.getIdUsuario());
                if (esAlumno)
                    return "perfilalumno";
                boolean esTutor = helper.esTutor(usuario.getIdUsuario());
                if (esTutor)
                    return "perfiltutor";
                else {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario no encontrado.", null);
                    faceContext.addMessage(null, message);
                }
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrecto", null);
                faceContext.addMessage(null, message);
                return "iniciosesion";
            }
        }
        return "iniciosesion";
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }   
}
