
package com.modelo;


public class Usuario {
    
    private int idUser;
    private int typeUserId;
    private String fullname;
    private String userName;
    private String password;
    private String typeNombre;
    
    //constructor
    public Usuario(){
        
    }
    
    // Setters and getters
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getTypeUserId() {
        return typeUserId;
    }

    public void setTypeUserId(int typeUserId) {
        this.typeUserId = typeUserId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeNombre() {
        return typeNombre;
    }

    public void setTypeNombre(String typeNombre) {
        this.typeNombre = typeNombre;
    }
    
}
