package com.idao;

import com.modelo.Usuario;

public interface IUsuarioDAO {
    
    public boolean signinUser(Usuario usr);
    public boolean loginUser(Usuario usr);
    public int actualizar(Usuario obj,String username_old);
    public int eliminar(String username);
    public boolean existeUser(String username);
    public int changePassword(String username, String newPassword);
    public int changeUsername(String username_old,String username_new);
    public int changeBoth(String username_old,String username_new,String newPassword);
    
}
