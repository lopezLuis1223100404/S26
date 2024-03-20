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
import mx.utng.s26.model.entity.Grupo;
import mx.utng.s26.model.service.IGrupoService;

@Controller
@SessionAttributes("grupo")
public class GrupoController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IGrupoService grupoService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/grupo/list","/grupo","/grupo/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de grupos");
    model.addAttribute("grupos", grupoService.list());
    return "glist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/grupo/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de grupos");
        model.addAttribute("grupo", new Grupo());
        return "gform";
    }

    @GetMapping("/grupo/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Grupo grupo = null;
        if (id>0) {
            grupo = grupoService.getById(id);
        }else{
            return "redirect:glist";
        }

        model.addAttribute("title", "Editar grupo");
        model.addAttribute("grupo", grupo);
        return "gform";
    }


    @PostMapping ("/grupo/form")
    public String save(@Valid Grupo grupo, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de grupos");
            return "gform";
        }

        grupoService.save(grupo);
        return "redirect:/grupo/list";
    }

    @GetMapping("/grupo/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            grupoService.delete(id);
        }
        return "redirect:/grupo/list";
    }

}

