package Mapper;

import POJO.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface RoleMapper {



    /**
     *  按 id 查询数据
     * @param id
     * @return Role对象
     */

   // @Select(" select id,name as roleName,age from ROLE where id = #{id}")
    public Role selectRoleById(String id);

    /**
     *
     * @param role
     * @return
     */
    //@Update("update ROLE set id=#{id,jdbcType=NUMERIC}, name = #{roleName,jdbcType=VARCHAR}, age = #{age,jdbcType=NUMERIC} where ID = #{id,jdbcType=VARCHAR}")
    public int updateRole(Role role);


    //@Delete("delete from ROLE where id = #{id} or NAME = #{roleName}")
    public int deleteRole(Role role);

    /**
     * 插入 数据
     * @return
     */
   // @Insert("insert into role(id,name,age) values (#{id}, #{roleName},#{age})")
    public int insertRole(Role role);


    /**
     * 模糊查询同姓的人数
     * @param name
     * @return
     */
    public Integer selectAllByFirstName(String firstName);

    /**
     * 按 map 查询 list
     * @param map
     * @return
     */
    public List<Role> findAllByMap(Map<String, Object> map);


    /**
     * 使用注解传递参数
     * @param name
     * @param ag
     * @return
     */
    public List<Role> findAllByAnno(@Param("rolename") String name, @Param("age") Integer ag);

    /**
     * 通过JavaBean 传递参数,但是xml文件中参数得使用驼峰命名
     * @return
     */
    public List<Role> findAllByBean(Role role);

    /**
     * 返回Map集合
     * @param name
     * @return
     */
    public Role findAllToMap(String name);


}
