package cn.murphy.springbootLearning.repository;

import cn.murphy.springbootLearning.pojo.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IDemoRepository  extends CrudRepository<Demo,Long> {
}
