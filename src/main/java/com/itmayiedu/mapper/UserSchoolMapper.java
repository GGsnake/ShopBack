/*package com.itmayiedu.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import com.itmayiedu.entity.User;
import com.itmayiedu.entity.UserEntity;
@CacheConfig(cacheNames = "baseCache")
public interface UserSchoolMapper {
	@Select("SELECT * FROM USERS WHERE NAME = #{name}")
	User findByName(@Param("name") String name);

	@Insert("INSERT INTO USERS(NAME, AGE) VALUES(#{name}, #{age})")
	int insert(@Param("name") String name, @Param("age") Integer age);
	
	@Select("select * from users where name=#{name}")
	@Cacheable
	UserEntity findName(@Param("name") String name);

	@Insert("insert into users values(null,#{name},#{age});")
	int addUser(UserEntity userEntity);
	
}*/

package com.itmayiedu.mapper;
import com.itmayiedu.entity.UserSchool;
public interface  UserSchoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert( UserSchool record);

    int insertSelective( UserSchool record);

     UserSchool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective( UserSchool record);

    int updateByPrimaryKey( UserSchool record);
}