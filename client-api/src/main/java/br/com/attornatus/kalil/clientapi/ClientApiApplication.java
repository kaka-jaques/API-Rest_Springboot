package br.com.attornatus.kalil.clientapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApiApplication {

	public static void main(String[] args) throws IOException {
		
		String content;
		
		URL url = new URL("https://kaka-jaques.github.io/content/mark.html");
		
		BufferedReader page = new BufferedReader(new InputStreamReader(url.openStream()));
		
		while((content = page.readLine()) != null) {
			System.out.println(content);
		}
		
		SpringApplication.run(ClientApiApplication.class, args);
		
	}

}
