package com.gabia.hjjae2.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)    // 스프링부트 - Junit 연결자 역할
@SpringBootTest     // <-> @WebMvcTest
public class PostsRepositoryTest {
    // 데이터베이스 CRUD 잘 작동하는지 테스트
    // save, findAll 기능 테스트

    @Autowired
    PostsRepository postsRepository;    // interface ---> CRUD

    @After  // Junit 에서 단위 테스트가 끝날 때마다 수행되는 메소드 지정
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void posts_save_call(){
        String title = "제목글";
        String content = "본문글";
        String author = "작성자";

        // 데이터 저장
        postsRepository.save(Posts.builder().title(title).content(content).author(author).build());

        // 데이터 조회
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);     // 0 번째 아이템 get
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
