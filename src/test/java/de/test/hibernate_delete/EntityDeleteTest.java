package de.test.hibernate_delete;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = HibernateDeleteApplication.class)
public class EntityDeleteTest {
    @Autowired private EntityRepository repository;
    @Test public void testDelete() {
        Entity storedSample = repository.saveAndFlush(new Entity("data"));
        assertNotNull(storedSample.getId());
        repository.delete(storedSample);
        repository.flush();
        assertThrows(EntityNotFoundException.class, () -> assertNull(repository.getOne(storedSample.getId())));
    }
}
