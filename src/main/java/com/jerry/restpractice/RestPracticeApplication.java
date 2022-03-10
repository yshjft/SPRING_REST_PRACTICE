package com.jerry.restpractice;

import com.jerry.restpractice.domain.uesr.domain.User;
import com.jerry.restpractice.global.database.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class RestPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestPracticeApplication.class, args);

		initData();
	}

	public static void initData() {
		Data.users.add(User.builder()
						.id(1L)
						.name("a")
						.birthDate(LocalDate.parse("1998-05-05", DateTimeFormatter.ISO_DATE))
						.address("경기도 ~~~")
				.build());

		Data.users.add(User.builder()
				.id(2L)
				.name("b")
				.birthDate(LocalDate.parse("1998-06-06", DateTimeFormatter.ISO_DATE))
				.address("대한민구 어딘가 *****")
				.build());

		Data.users.add(User.builder()
				.id(3L)
				.name("c")
				.birthDate(LocalDate.parse("1998-07-07", DateTimeFormatter.ISO_DATE))
				.address("대한민국 어딘가 ~~~~")
				.build());
	}
}
