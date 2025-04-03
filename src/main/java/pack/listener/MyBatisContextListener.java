package pack.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import pack.mybatis.SqlMapConfig;

public class MyBatisContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("웹 애플리케이션 시작됨 - MyBatis 초기화 완료");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("웹 애플리케이션 종료됨 - MyBatis 커넥션 해제 시작");
        SqlMapConfig.shutdown();  // 종료 시 호출!
    }
}