package edu.nf.ch08.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 洒度
 * @date 2020/12/2
 */
public class MybatilsUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try{
            InputStream is= Resources.getResourceAsStream("mybatils.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
