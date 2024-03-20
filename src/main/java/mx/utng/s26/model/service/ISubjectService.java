package mx.utng.s26.model.service;

import java.util.List;

import mx.utng.s26.model.entity.Subject;


public interface ISubjectService {
    List<Subject> list();
    void save(Subject subject);
    Subject getById(Long id);
    void delete(Long id);
}
