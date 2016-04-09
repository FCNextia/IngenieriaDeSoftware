package modelo;
// Generated 9/04/2016 10:24:29 AM by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int idUsuario;
     private String correoUsuario;
     private String nombreUsuario;
     private String apellidoPaternoUsuario;
     private String apellidoMaternoUsuario;
     private String contraseniaUsuario;
     private int telefonoUsuario;
     private String acercaDeUsuario;
     private Alumno alumno;
     private Tutor tutor;

    public Usuario() {
    }

	
    public Usuario(int idUsuario, String correoUsuario, String nombreUsuario, String apellidoPaternoUsuario, String apellidoMaternoUsuario, String contraseniaUsuario, int telefonoUsuario, String acercaDeUsuario) {
        this.idUsuario = idUsuario;
        this.correoUsuario = correoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoPaternoUsuario = apellidoPaternoUsuario;
        this.apellidoMaternoUsuario = apellidoMaternoUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.acercaDeUsuario = acercaDeUsuario;
    }
    public Usuario(int idUsuario, String correoUsuario, String nombreUsuario, String apellidoPaternoUsuario, String apellidoMaternoUsuario, String contraseniaUsuario, int telefonoUsuario, String acercaDeUsuario, Alumno alumno, Tutor tutor) {
       this.idUsuario = idUsuario;
       this.correoUsuario = correoUsuario;
       this.nombreUsuario = nombreUsuario;
       this.apellidoPaternoUsuario = apellidoPaternoUsuario;
       this.apellidoMaternoUsuario = apellidoMaternoUsuario;
       this.contraseniaUsuario = contraseniaUsuario;
       this.telefonoUsuario = telefonoUsuario;
       this.acercaDeUsuario = acercaDeUsuario;
       this.alumno = alumno;
       this.tutor = tutor;
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getCorreoUsuario() {
        return this.correoUsuario;
    }
    
    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getApellidoPaternoUsuario() {
        return this.apellidoPaternoUsuario;
    }
    
    public void setApellidoPaternoUsuario(String apellidoPaternoUsuario) {
        this.apellidoPaternoUsuario = apellidoPaternoUsuario;
    }
    public String getApellidoMaternoUsuario() {
        return this.apellidoMaternoUsuario;
    }
    
    public void setApellidoMaternoUsuario(String apellidoMaternoUsuario) {
        this.apellidoMaternoUsuario = apellidoMaternoUsuario;
    }
    public String getContraseniaUsuario() {
        return this.contraseniaUsuario;
    }
    
    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }
    public int getTelefonoUsuario() {
        return this.telefonoUsuario;
    }
    
    public void setTelefonoUsuario(int telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }
    public String getAcercaDeUsuario() {
        return this.acercaDeUsuario;
    }
    
    public void setAcercaDeUsuario(String acercaDeUsuario) {
        this.acercaDeUsuario = acercaDeUsuario;
    }
    public Alumno getAlumno() {
        return this.alumno;
    }
    
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    public Tutor getTutor() {
        return this.tutor;
    }
    
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }




}


