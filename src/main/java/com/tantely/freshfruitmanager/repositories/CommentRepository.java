package com.tantely.freshfruitmanager.repositories;

import com.tantely.freshfruitmanager.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
