package io.sbed.modules.sys.dao;

import io.sbed.modules.sys.entity.SysDaygoods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysDaygoodsDao extends BaseDao<SysDaygoods> {
    @Select("select * from jh_day_goods limit #{page}, #{pageSize}")
    List<SysDaygoods> queryListGod(@Param("page") Integer page, @Param("pageSize") Integer pageSize);

    List<SysDaygoods> queryList(Map<String, Object> map);

    List<SysDaygoods> queryListFirend(Map<String, Object> map);

    @Select("select id from jh_day_goods where content=#{content}")
    SysDaygoods queryId(String content);

    @Select("select id from jh_friend_dto where content=#{content}")
    SysDaygoods queryIdFriend(String content);

    @Select("select IFNULL(count(*),0) from jh_day_goods")
   Integer countDayGoods();

    @Select("select IFNULL(count(*),0) from jh_friend_dto")
   Integer countFirend();
    @Select("select image from jh_day_image where day=#{id}")
    List<String> getImages(Integer id);

    @Select("select image from jh_friend_image where day=#{id}")
    List<String> getImagesFriend(Integer id);

    @Insert("insert into jh_day_image(image,day,createTime) values (#{image},#{day},now())")
    Integer saveDayImg(Map<String, Object> map);
    @Insert("insert into jh_friend_image(image,day,createTime) values (#{image},#{day},now())")
    Integer saveFirendImg(Map<String, Object> map);
    @Insert("insert into jh_day_goods(titile,content,image,createTime) values (#{titile},#{content},#{image},now())")
    Integer saveDayGoods(Map<String, Object> map);

    @Insert("insert into jh_friend_dto(titile,content,image,createTime) values (#{titile},#{content},#{image},now())")
    Integer saveFirend(Map<String, Object> map);



    int deleteBatch(Object[] id);
    int deleteBatchFirend(Object[] id);


}
