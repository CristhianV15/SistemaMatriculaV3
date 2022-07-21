package modelo.util;

import java.util.ArrayList;
import java.util.List;

public class DbEstado {
    private int id;
    private String nombre;
    public List<DbEstado> getEstadosAll(){
        List<DbEstado> lista = new ArrayList<>();
        lista.add((new DbEstado(1, "Activo")));
        lista.add((new DbEstado(2, "Inactivo")));
        lista.add((new DbEstado(3, "Anulado")));
        lista.add((new DbEstado(0, "Eliminado")));
        return lista;
    }
    public List<DbEstado> getEstados(){
        List<DbEstado> lista = new ArrayList<>();
        lista.add((new DbEstado(1, "Activo")));
        lista.add((new DbEstado(2, "Inactivo")));
        //lista.add((new DbEstado(3, "Anulado")));        
        return lista;
    }

    public DbEstado() {
    }

    public DbEstado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
