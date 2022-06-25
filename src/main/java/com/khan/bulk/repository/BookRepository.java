package com.khan.bulk.repository;

import com.khan.bulk.entity.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Modifying
    @Query(
            value = "truncate table book",
            nativeQuery = true
    )
    @Transactional
    void truncateBookTable();
}
