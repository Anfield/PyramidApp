package com.mongospring.web.services;

import com.mongospring.web.dao.ContactDao;
import com.mongospring.web.dao.SequenceDao;
import com.mongospring.web.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA 13.
 * by Anfield.
 */
@Service
public class ContactService {
    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private ContactDao contactDao;

    public void add(Contact contact) {
        contact.setId(sequenceDao.getNextSequenceId(Contact.COLLECTION_NAME));
        contactDao.save(contact);
    }

    public void update(Contact contact) {
        contactDao.save(contact);
    }

    public Contact get(Long id) {
        return contactDao.get(id);
    }

    public List<Contact> getAll() {
        return contactDao.getAll();
    }

    public void remove(Long id) {
        contactDao.remove(id);
    }
}