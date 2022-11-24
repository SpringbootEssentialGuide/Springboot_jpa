package com.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// !!! 정리 !!!
//
//1. 엔티티 설계 (data-entity-product)
//
//		2. 리포지토리 인터페이스 생성 (data-repository-ProductRepository), JpaRepository 상속
//		> 상속받을 때는 대상 엔티티와 기본값 타입을 지정해야 함.
//		> 엔티티를 사용하기 위해서는 위와 같이 대상 엔티티를 Product로 설정하고 해당 엔티티의 @Id 필드 타입인 Long 을 설정하면 됩니다.
//
//		3. DAO 설계(data-dao Package)
//		> DAO 클래스는 일반적으로 "인터페이스-구현체" 구성으로 생성
//		> ProductDAO (CRUD) 인터페이스 생성, 그 인터페이스를 상속받는 ProductDAOImpl 클래스 생성
//		> 리턴값으로 데이터 객체를 전달하게 되는데, 엔티티로 할지, 데이터 객체(DTO)로 할지에 대해서는 의견이 분분하다.
//		> 책의 예제에서는 엔티티로 전달함
//
//		4. DAO 연동을 위한 컨트롤러와 서비스 설계
//		> 리턴값으로 데이터 객체(DTO)로 하므로 DTO 객체를 먼저 선언 (ProductDto, ProductResponseDto, ChangeProductNameDto 등...)
@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {

		SpringApplication.run(JpaApplication.class, args);
	}

}
