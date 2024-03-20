package mx.utng.s26.model.dao;

import java.util.List;

import mx.utng.s26.model.entity.Subject;


public interface ISubjectDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Subject> list();

    //Guardar un estudiante
    void save(Subject subject);

    //Obterner un estudiante en especifico a partir del id
    Subject getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}
