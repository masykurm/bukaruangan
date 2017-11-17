package bl.core.hackathon.cfg;

import java.beans.PropertyVetoException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import bl.core.hackathon.database.DatabaseRepository;
import bl.core.hackathon.database.DatabaseService;

@Configuration
public class DatabaseConfiguration {

	@Value("${c3p0.pool.max_size}")
    private int maxPoolSize;
 
    @Value("${c3p0.pool.min_size}")
    private int minPoolSize;
 
    @Value("${c3p0.acquire_increment}")
    private int acquireIncrement;
 
    @Value("${c3p0.idle_test_period}")
    private int idleTestPeriod;
 
    @Value("${c3p0.max_statements}")
    private int maxStatements;
 
    @Value("${c3p0.max_idle_time}")
    private int maxIdleTime;
    
    @Value("${c3p0.retry.num}")
    private int numOfRetryAttempts;
    
    @Value("${c3p0.connection.test.oncheckin}")
    private boolean testConnectionOnCheckin;
 
    @Value("${c3p0.url}")
    private String url;
 
    @Value("${c3p0.username}")
    private String username;
 
    @Value("${c3p0.password}")
    private String password;
 
    @Value("${c3p0.driverClassName}")
    private String driverClassName;
 
    @Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setMaxPoolSize(maxPoolSize);
        dataSource.setMinPoolSize(minPoolSize);
        dataSource.setAcquireIncrement(acquireIncrement);
        dataSource.setIdleConnectionTestPeriod(idleTestPeriod);
        dataSource.setTestConnectionOnCheckin(testConnectionOnCheckin);
        dataSource.setAcquireRetryAttempts(numOfRetryAttempts);
        dataSource.setMaxStatements(maxStatements);
        dataSource.setMaxIdleTime(maxIdleTime);
        dataSource.setJdbcUrl(url);
        dataSource.setPassword(password);
        dataSource.setUser(username);
        dataSource.setDriverClass(driverClassName);
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate c3p0JdbcTemplate(){
    	//Fallback to native JdbcTemplate
    	JdbcTemplate c3p0Template = new JdbcTemplate();
		try {
			System.out.println("trace-c3p0-initializer : trying to construct C3P0JdbcTemplate");
			c3p0Template = new JdbcTemplate(dataSource());
			System.out.println("trace-c3p0-initializer : successfully construct C3P0JdbcTemplate - "+c3p0Template);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			
			System.out.println("trace-c3p0-initializer : failed to construct C3P0JdbcTemplate , fallback to native JDBCTemplate");
			e.printStackTrace();
		}
    	
    	return c3p0Template;
    }
    
    @Bean 
    public DatabaseRepository databaseRepository() {
    	
    	return new DatabaseRepository();
    }
        
}
