package hello.hellospring; //요기 하위 패키지는 컴포넌트 스캔함 , 위에 패키지는 스캔되지않음

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
