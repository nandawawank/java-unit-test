package nanda.wawan.kurniawan.test.repository;

import nanda.wawan.kurniawan.test.data.Person;

public interface PersonRepository {
    Person selectById(String id);

    void insert(Person person);
}
