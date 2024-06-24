package com.sj.demo.dao;

import com.sj.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = """
            select u
            from users u join orders o on u.id = o.uid
            group by u.id
            having count(o.oid) > :minOrder
            """)
    List<UserEntity> findUsersByMinOrders(@Param("minOrder") String minOrder);
}
