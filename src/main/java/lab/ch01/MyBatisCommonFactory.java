package lab.ch01;

import java.io.FileNotFoundException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MyBatisCommonFactory {
	static Logger logger = Logger.getLogger(MyBatisCommonFactory.class);
	public static SqlSessionFactory sqlSessionFactory = null;
	// 생성자
	public MyBatisCommonFactory() {
		init(); // 초기화 메서드 호출
	}
	public void init() {
		try {
			String resource = "com/mybatis/MapperConfig.xml";
			/* String resource = "com/mybatis/Configuration.xml"; */
			Reader reader = Resources.getResourceAsReader(resource);
			logger.info("before sqlSessionFactory:"+sqlSessionFactory);
			if(sqlSessionFactory==null) {
			logger.info("if sqlSessionFactory:"+sqlSessionFactory);
			sqlSessionFactory = 
						new SqlSessionFactoryBuilder().build(reader, "development");
			}// end of if
		} catch (FileNotFoundException ffe) {
			ffe.getMessage();
		} catch(Exception e) {
			e.getMessage();
		}
	} // end of init
	/* */
	public SqlSessionFactory getSqlSessionFactory() {
		init();
		return sqlSessionFactory; // 전역변수 -> 최초는 Null로 되어 있음.
	}// end of getSqlSessionFactory
	
}