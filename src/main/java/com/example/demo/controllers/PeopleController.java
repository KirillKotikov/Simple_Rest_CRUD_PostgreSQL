package com.example.demo.controllers;

import com.example.demo.dao.PersonDAO;
import com.example.demo.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PeopleController {

    @Autowired
    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    // Получаем всех людей из DAO и передаем их в отображение
    @GetMapping("/people")
    public String index(Model model) {

       model.addAttribute("people", personDAO.index());
        return "people/people";
    }

    // Отображаем одного человека по заявлнному id в DAO
    @GetMapping("/people/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/people/new")
    public String newPeople(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping("/people")
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";

        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/people/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/people/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") int id ) {
        if (bindingResult.hasErrors())
            return "/people/edit";

        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/people/{id}")
    public String delete(@PathVariable("id") int id ) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
