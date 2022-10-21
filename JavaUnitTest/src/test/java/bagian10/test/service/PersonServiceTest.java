package bagian10.test.service;

import bagian10.data.Person;
import bagian10.repository.PersonRepository;
import bagian10.service.PersonService;
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
            personService.get("not found");
        });
    }

    @Test
    void testGetPersonSuccess() {
        // Menambah behavior ke mock object
        Mockito.when(personRepository.selectById("aera"))
                .thenReturn(new Person("aera", "Aera"));

        var person = personService.get("aera");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("aera", person.getId());
        Assertions.assertEquals("Aera", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        var person = personService.register("Aera");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Aera", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "Aera"));
    }
}
