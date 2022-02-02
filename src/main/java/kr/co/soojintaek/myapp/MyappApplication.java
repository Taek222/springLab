package kr.co.soojintaek.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"kr.co.soojintaek"})
public class MyappApplication { // 준택입니다.

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
		//feature_220124_psj_git_test_commit
	}

}
