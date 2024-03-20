package mx.utng.s26.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.s26.model.entity.Grupo;

@Repository
public class GrupoDaoImpl implements IGrupoDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Grupo> list() {
        return em.createQuery("from Grupo").getResultList();
    }

    @Override
    public void save(Grupo grupo) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(grupo.getId() != null && grupo.getId()>0){
            em.merge(grupo);
        }else{
            //Registro nuevo al usar persist
            em.persist(grupo);
        }
    }

    @Override
    public Grupo getById(Long id) {
        return em.find(Grupo.class, id);
    }

    @Override
    public void delete(Long id) {
      Grupo grupo = getById(id);
    em.remove(grupo);
    }
    

}