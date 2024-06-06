package app.controller;

import app.entity.Contact;
import app.service.impl.contact.ContactService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping("/contacts")
    public String fetchAllMembers(Model model) {
        List<Contact> list = contactService.fetchAll();
        model.addAttribute("name", "Contacts");
        model.addAttribute("contacts", list);
        return "member_list";
    }

    @RequestMapping("/create-contacts")

    public String createMember(Model model) {
        model.addAttribute("name", "Add Contact");
        return "contact_add";
    }

    @RequestMapping(value = "/add-contact", method = RequestMethod.POST)
    public RedirectView addMember(@ModelAttribute Contact contact, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/contacts");
        if ( contactService.create(contact) ) {
            return redirectView;
        } else return redirectView;
    }


    @RequestMapping("/update-contact/{id}")
    public String updateMember(@PathVariable("id") Long id, Model model) {
        model.addAttribute("title", "Update Member");
        Contact contact = contactService.fetchById(id);
        model.addAttribute("contact", contact);
        return "contact_update";
    }

    @RequestMapping(value = "/change-contact", method = RequestMethod.POST)
    public RedirectView changeMember(@ModelAttribute Contact contact, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/members");
        if ( contactService.update(contact.getId(), contact) ) {
            return redirectView;
        } else return redirectView;
    }

    @RequestMapping("/delete-member/{id}")
    public RedirectView deleteMember(@PathVariable("id") Long id,
                                     HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/members");
        if ( contactService.delete(id) ) {
            return redirectView;
        } else return redirectView;
    }
}
