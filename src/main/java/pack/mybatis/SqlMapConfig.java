package pack.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class SqlMapConfig {
    public static SqlSessionFactory sqlSessionFactory;  //DB의 SQL명령을 실행시킬 때 필요한 메소드를 갖고 있다.

    static{
        String resource = "Configuration.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (Exception e) {
            System.out.println("SqlMapConfig 오류 : " + e);
        }
    }

    public static SqlSessionFactory getSqlSession(){
        return sqlSessionFactory;
    }

    // 종료 메서드 추가
    public static void shutdown() {
        try {
            // 내부 커넥션 풀 사용 시 아래처럼 다운캐스팅 후 종료
            if (sqlSessionFactory != null) {
                javax.sql.DataSource ds = sqlSessionFactory.getConfiguration().getEnvironment().getDataSource();
                if (ds instanceof org.apache.ibatis.datasource.pooled.PooledDataSource) {
                    ((org.apache.ibatis.datasource.pooled.PooledDataSource) ds).forceCloseAll();
                    System.out.println("MyBatis 커넥션 풀 종료 완료");
                }
                // 만약 HikariCP 사용 시
                /*
                if (ds instanceof com.zaxxer.hikari.HikariDataSource) {
                    ((HikariDataSource) ds).close();
                }
                */
            }
        } catch (Exception e) {
            System.out.println("MyBatis 종료 중 오류 : " + e);
        }
    }
}