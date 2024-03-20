package mx.utng.s26.model.dao;

import java.util.List;

import mx.utng.s26.model.entity.Grupo;


public interface IGrupoDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Grupo> list();

    //Guardar un estudiante
    void save(Grupo grupo);

    //Obterner un estudiante en especifico a partir del id
    Grupo getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}
