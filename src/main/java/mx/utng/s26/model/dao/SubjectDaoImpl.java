package mx.utng.s26.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.s26.model.entity.Subject;

@Repository
public class SubjectDaoImpl implements ISubjectDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Subject> list() {
        return em.createQuery("from Subject").getResultList();
    }

    @Override
    public void save(Subject subject) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(subject.getId() != null && subject.getId()>0){
            em.merge(subject);
        }else{
            //Registro nuevo al usar persist
            em.persist(subject);
        }
    }

    @Override
    public Subject getById(Long id) {
        return em.find(Subject.class, id);
    }

    @Override
    public void delete(Long id) {
      Subject subject = getById(id);
      em.remove(subject);
    }
    

}