package com.gabia.hjjae2.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// extends JpaRepository<T, ID>
public interface PostsRepository extends JpaRepository<Posts, Long> {
    // DB Layer 접근자
    // ibatis, MyBatis 등 ---> Dao
    // JPA ---> Repository
    // 단순히 인터페이스 생성 후 JpaRepository 상속하면 기본적인 CRUD 메소드 자동 생성
    // @Repository 를 추가할 필요 없음
    // 주의: Entity 클래스, 기본 Entity Repository 는 함께 위치해야 함
    // Entity 클래스는 기본 Repository 없이 제대로 된 역할 할 수 없음.
    // 패키지 자체로 관리하는 것 (함께 이동)
}
