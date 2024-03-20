package mx.utng.s26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.s26.model.dao.ISubjectDao;
import mx.utng.s26.model.entity.Subject;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class SubjectServiceImpl implements ISubjectService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private ISubjectDao subjectDao;

    @Transactional(readOnly = true)
    @Override
    public List<Subject> list() {
        return subjectDao.list();
    }

    @Transactional
    @Override
    public void save(Subject subject) {
        subjectDao.save(subject);
    }

    @Transactional(readOnly = true)
    @Override
    public Subject getById(Long id) {
        return subjectDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        subjectDao.delete(id);
    }

   /*  @Override
    public void save(Subject subject) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
     */
}
