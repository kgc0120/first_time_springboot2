package com.example.community_web.repository;

import com.example.community_web.domain.Board;
import com.example.community_web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
