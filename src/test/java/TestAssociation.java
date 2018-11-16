import Mapper.*;
import POJO.Impl.*;
import POJO.Inter.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;


public class TestAssociation {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(TestAssociation.class);

        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder= new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= null;
        SqlSession sqlSession = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession();

           /* //测试 TaskMapper
            System.out.println("测试TaskMapper");
            TaskMapper mapper1 = sqlSession.getMapper(TaskMapper.class);
            Task task = mapper1.getTask(1L);
            System.out.println(task);

            //测试 WorkCard
            System.out.println("测试WorkCard");
            WorkCardMapper mapper2 = sqlSession.getMapper(WorkCardMapper.class);
            WorkCard workCardByEmpId = mapper2.getWorkCardByEmpId(3L);
            System.out.println(workCardByEmpId);

            //测试EmployeeTaskMapper
            System.out.println("测试EmployeeTaskMapper");
            EmployeeTaskMapper mapper3 = sqlSession.getMapper(EmployeeTaskMapper.class);
            List<EmployeeTask> employeeTaskByEmpId = mapper3.getEmployeeTaskByEmpId(3L);

            for(EmployeeTask t:employeeTaskByEmpId){
                System.out.println(t);
            }

            //测试FemaleHealthFormMapper
            System.out.println("测试FemaleHealthFormMapper");
            FemaleHealthFormMapper mapper4 = sqlSession.getMapper(FemaleHealthFormMapper.class);
            FemaleHealthForm femaleHealthForm = mapper4.getFemaleHealthForm(4L);
            System.out.println(femaleHealthForm);

            //测试MaleHealthFormMapper
            System.out.println("测试MaleHealthFormMapper");
            MaleHealthFormMapper mapper5 = sqlSession.getMapper(MaleHealthFormMapper.class);
            MaleHealthForm maleHealthForm = mapper5.getMaleHealthForm(3L);
            System.out.println(maleHealthForm);*/

            //测试Employee
            System.out.println("测试Employee");
            EmployeeMapper mapper6 = sqlSession.getMapper(EmployeeMapper.class);

            /*logger.info(mapper6.getEmployee(4L));*/
            logger.info(mapper6.getEmployee(4L));
            sqlSession.commit();
            SqlSession sqlSession1 = sqlSessionFactory.openSession();
            EmployeeMapper mapper7 = sqlSession1.getMapper(EmployeeMapper.class);

            logger.info(mapper7.getEmployee(4L));
            sqlSession1.commit();




            /*System.out.println("测试EmployeeTaskMapper");
            EmployeeTaskMapper mapper3 = sqlSession.getMapper(EmployeeTaskMapper.class);


            logger.info(mapper3.getEmployeeTaskByEmpId(3L));*/


        } catch (IOException e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        
        
        
    }
}
