package bagian10.repository;

import bagian10.data.Person;

public interface PersonRepository {

    Person selectById(String id);

    void insert(Person person);
}
