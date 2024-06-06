package app.repository;

import app.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface BaseRepository <Contact>{

    boolean create(Contact contact);

    Optional<List<Contact>> fetchAll();

    boolean update(Long id, Contact contact);

    boolean delete(Long id);

    Optional<Contact> fetchById(Long id);
}

