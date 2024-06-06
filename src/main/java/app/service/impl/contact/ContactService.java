package app.service.impl.contact;

import app.entity.Contact;
import app.service.BaseService;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ContactService extends BaseService<Contact> {


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
