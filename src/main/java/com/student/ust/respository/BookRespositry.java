package com.student.ust.respository;

import com.student.ust.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Book respositry.
 */
@Repository
public interface BookRespositry  extends JpaRepository<Book,Integer>
 {


}
