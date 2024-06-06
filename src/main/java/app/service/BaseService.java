package app.service;

import app.entity.Contact;
import jakarta.transaction.Transactional;

import java.util.List;

public interface BaseService <Contact> {

    @Transactional
    boolean create(Contact contact);

    @Transactional
    List<Contact> fetchAll();

    @Transactional
    Contact fetchById(Long id);

    @Transactional
    boolean update(Long id, Contact contact);

    @Transactional
    boolean delete(Long id);

}
