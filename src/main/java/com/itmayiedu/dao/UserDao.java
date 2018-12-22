
package com.itmayiedu.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.itmayiedu.entity.UserSchool;
public interface UserDao extends JpaRepository<UserSchool, Integer> {

}
