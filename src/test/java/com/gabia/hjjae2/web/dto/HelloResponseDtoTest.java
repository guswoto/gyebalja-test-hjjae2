package com.gabia.hjjae2.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombok_func_test(){
        // 데이터 생성
        String name = "TEST";
        int amount = 1000;

        // 객체 생성
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // 테스트 - RequestArgsConstructor 생성자가 잘 작동하는지
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

        // curl http://localhost:8080
    }

}
