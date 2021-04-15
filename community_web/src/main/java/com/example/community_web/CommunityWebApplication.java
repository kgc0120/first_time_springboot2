package com.example.community_web;

import com.example.community_web.domain.Board;
import com.example.community_web.domain.User;
import com.example.community_web.domain.enums.BoardType;
import com.example.community_web.repository.BoardRepository;
import com.example.community_web.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class CommunityWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityWebApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository) throws Exception {
        return (args) -> {
            User user = userRepository.save(User.builder()
                    .name("havi")
                    .password("test")
                    .email("havi@gmail.com")
                    .createdDate(LocalDateTime.now())
                    .build());

            IntStream.rangeClosed(1, 200).forEach(index ->
                    boardRepository.save(Board.builder()
                            .title("게시글"+index)
                            .subTitle("순서"+index)
                            .content("컨텐츠")
                            .boardType(BoardType.free)
                            .createdDate(LocalDateTime.now())
                            .updatedDate(LocalDateTime.now())
                            .user(user).build())
            );
        };
    }

}
