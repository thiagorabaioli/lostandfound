package thiagorabaioli.Lostandfound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LostandfoundApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(LostandfoundApplication.class, args);
		System.out.println("Hello World");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(passwordEncoder.encode("123456"));
		boolean b = passwordEncoder.matches("123456", passwordEncoder.encode("$2a$10$Vw1mzVoy/QGUEwhuN8vW1eUg8UUEGGxuXIu9rUb8.p2vgmhjyO3q6"));
        System.out.println(b);
	}
}
