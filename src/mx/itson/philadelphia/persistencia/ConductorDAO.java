/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.philadelphia.persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.philadelphia.entidades.Conductor;
import mx.itson.philadelphia.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Carlos
 */
public class ConductorDAO {
    
    /**
     * Se obtienen todos los registros de la tabla
     * @return Lista de Conductores
     */
    public static List<Conductor> obtenerTodos(){
        List<Conductor> conductores = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Conductor> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Conductor.class);
            criteriaQuery.from(Conductor.class);
            
            conductores = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return conductores;
    }
    
    /**
     * Guarda los registros de los conductores
     * @param nombre Nombre de los conductores
     * @param numeroLicencia El numero de la licencia de los conductores
     * @param fechaAlta La fecha de alta de la multa
     * @return Guarda el registro final de la multa
     */
    
    public boolean guardar(String nombre, String numeroLicencia, Date fechaAlta){
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Conductor c= new Conductor();
            c.setNombre(nombre);
            c.setNumeroLicencia(numeroLicencia);
            c.setFechaAlta(fechaAlta);
            
            session.save(c);
            
            session.getTransaction().commit();
            
            resultado = c.getId() !=0;
        }catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
    
    /**
     * Obtienen los conductores por medio de su id
     * @param id numero de identificacion de los conductores
     * @return Regresa el registro deseado
     */
    public Conductor obtenerPorId(int id){
        Conductor conductor = null;
        try{
            
        }catch(HibernateException ex){
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return null;
    }
}
