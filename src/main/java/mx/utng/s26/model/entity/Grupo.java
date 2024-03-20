package mx.utng.s26.model.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Grupo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String name;

    @Column (length = 100, nullable = false)
    @NotEmpty
    private String anioEscolar;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String nivelAcademico;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String tutorGrupo;

    @Temporal(TemporalType.DATE)
    private Date recordAt;

    @PrePersist
    public void PrePersist(){
        recordAt = new Date();
    }


    //GETTERS Y SETTERS
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getRecordAt() {
        return recordAt;
    }
    public void setRecordAt(Date recordAt) {
        this.recordAt = recordAt;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getAnioEscolar() {
        return anioEscolar;
    }
    public String getNivelAcademico() {
        return nivelAcademico;
    }
    public String getTutorGrupo() {
        return tutorGrupo;
    }
    public void setAnioEscolar(String anioEscolar) {
        this.anioEscolar = anioEscolar;
    }
    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }
    public void setTutorGrupo(String tutorGrupo) {
        this.tutorGrupo = tutorGrupo;
    }
}
