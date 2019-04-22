package me.xueyao.mapper;

import me.xueyao.domain.Person;
import org.springframework.stereotype.Repository;

/**
 * @author: Simon.Xue
 * @date: 2019/3/22 10:07
 */
@Repository
public interface PersonMapper {
    Person getPerson(int id);

    int update(Person person);
}
