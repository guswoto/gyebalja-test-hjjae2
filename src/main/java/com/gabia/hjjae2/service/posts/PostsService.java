package com.gabia.hjjae2.service.posts;

import com.gabia.hjjae2.domain.posts.Posts;
import com.gabia.hjjae2.domain.posts.PostsRepository;
import com.gabia.hjjae2.web.dto.PostsResponseDto;
import com.gabia.hjjae2.web.dto.PostsSaveRequestDto;
import com.gabia.hjjae2.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    // Service ---> 트랜잭션, 도메인 간 순서 보장 역할
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id){
        // id에 맞는 Posts 객체 조회, 추출
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        // dto로 반환
        return new PostsResponseDto(entity);
    }
}
