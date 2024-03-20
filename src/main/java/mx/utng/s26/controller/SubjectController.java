package mx.utng.s26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import mx.utng.s26.model.entity.Subject;
import mx.utng.s26.model.service.ISubjectService;

@Controller
@SessionAttributes("subject")
public class SubjectController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private ISubjectService subjectService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/subject/list","/subject","/subject/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Materias");
    model.addAttribute("subjects", subjectService.list());
    return "sulist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/subject/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Materias");
        model.addAttribute("subject", new Subject());
        return "suform";
    }

    @GetMapping("/subject/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Subject subject = null;
        if (id>0) {
            subject = subjectService.getById(id);
        }else{
            return "redirect:sulist";
        }

        model.addAttribute("title", "Editar Materias");
        model.addAttribute("subject", subject);
        return "suform";
    }


    @PostMapping ("/subject/form")
    public String save(@Valid Subject subject, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Materias");
            return "suform";
        }

        subjectService.save(subject);
        return "redirect:/subject/list";
    }

    @GetMapping("/subject/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            subjectService.delete(id);
        }
        return "redirect:/subject/list";
    }

}

