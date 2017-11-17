package bl.core.hackathon.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bl.core.hackathon.database.DatabaseService;
import bl.core.hackathon.rest.RoomService;

@Configuration
public class ServiceConfiguration {


    @Bean
    public DatabaseService databaseService() {
    	return new DatabaseService();
    }
    

    @Bean
    public RoomService roomService() {
    	return new RoomService();
    }
}

