/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.philadelphia.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.philadelphia.entidades.Oficial;
import mx.itson.philadelphia.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Carlos
 */
public class OficialDAO {
    
    /**
     * Se obtienen todos los registros de la tabla
     * @return Lista de Oficiales
     */
    public static List<Oficial> obtenerTodos(){
        List<Oficial> oficiales = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Oficial> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Oficial.class);
            criteriaQuery.from(Oficial.class);
            
            oficiales = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return oficiales;
        
    }
    
    /**
     * Guarda los registros de los conductores
     * @param nombre Guarda el nombre de los Oficiales
     * @param telefono Guarda el telefono de los Oficiales
     * @return Retorna todo el registro de los Ofciales
     */
    public boolean guardar( String nombre, int telefono){
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Oficial o= new Oficial();
            o.setNombre(nombre);
            o.setTelefono(nombre);
            
            session.save(o);
            
            session.getTransaction().commit();
            
            resultado = o.getId() !=0;
        }catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
    /**
     * Obtienen los conductores por medio de su id
     * @param id numero de identificacion de los Oficiales
     * @return Regresa el registro deseado
     */
    public Oficial obtenerPorId(int id){
        Oficial oficial = null;
        try{
            
        }catch(HibernateException ex){
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return null;
    }
    
}
