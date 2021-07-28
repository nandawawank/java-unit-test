package nanda.wawan.kurniawan.test.service;

import nanda.wawan.kurniawan.test.data.Person;
import nanda.wawan.kurniawan.test.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get("Not Found");
        });
    }

    @Test
    void testGetPersonSuccess() {
        // menambahkan behavior ke mock objek
        Mockito.when(personRepository.selectById("Nanda"))
                .thenReturn(new Person("Nanda", "Wawan"));

        var person = personService.get("Nanda");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("Nanda", person.getId());
        Assertions.assertEquals("Wawan", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        var person = personService.register("Nanda");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("Nanda", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "Nanda"));
    }
}
