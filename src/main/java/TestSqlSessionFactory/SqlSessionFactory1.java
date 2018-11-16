package TestSqlSessionFactory;

import Mapper.RoleMapper;
import POJO.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.apache.ibatis.type.TypeHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SqlSessionFactory1 {



    public static void main(String[] args) {


        /*通过代码方式注册别名*/
       /* TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();
        typeAliasRegistry.registerAlias("roleM", Role.class);*/



        SqlSessionFactory sqlSessionFactory = null;
        InputStream inputStream = null;
        String resource = "mybatis-config.xml";
        SqlSession sqlSession = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //创建 SqlSessionFactory 建设者对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

            //通过 SqlSessionFactory 建设者 创建 SqlSessionFactory 对象
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);


            sqlSession = sqlSessionFactory.openSession();
            System.out.println(sqlSession);

            /*通过配置文件创建Mapper*/
            /*Role selectRoleById = (Role)sqlSession.selectOne("selectRoleById","1");
            System.out.println(selectRoleById);

            Integer selectAll = sqlSession.selectOne("RoleMapper.selectAllByFirstName", "zhou");

            System.out.println(selectAll);*/

            /*通过接口创建Mapper*/

            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

            Integer allCount = mapper.selectAllByFirstName("zhou");
            System.out.println(allCount);

            /*
            //使用Map传递参数
            Map<String,Object> map = new HashMap<String, Object>();

            map.put("rolename","li");
            map.put("age",5);
            List<Role> allByMap = mapper.findAllByMap(map);
            */


            /*//使用 注解传递参数
            List<Role> li = mapper.findAllByAnno("li", 2);*/

            //通过JAVABean传递参数

            Role role = new Role();
            role.setRoleName("li");
            role.setAge(6);

            List<Role> allByBean = mapper.findAllByBean(role);


            for(Role r:allByBean){
                System.out.println(r);
            }

           //查询
            Role role1 = mapper.selectRoleById("2");
            System.out.println(role1);


            Role allToMap = mapper.findAllToMap("15");

            System.out.println("allToMap ==> :"+allToMap);


          /*   //
            Role role2 = new Role();
            role2.setId("6");
            role2.setRoleName("lijunqi");
            role2.setAge(98);
            mapper.insertRole(role2);
            System.out.println(mapper.selectRoleById("6"));

            //删除

            Role role3 = new Role();
            role3.setId("6");
            mapper.deleteRole(role3);
            System.out.println(mapper.selectRoleById("6"));

             //更新
            Role role4 = new Role();
            role4.setId("3");
            role4.setRoleName("zhouhai");
            role4.setAge(98);
            mapper.updateRole(role4);
            System.out.println(mapper.selectRoleById("3"));*/ {
                sqlSession.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {

            sqlSession.close();
        }


    }

}
