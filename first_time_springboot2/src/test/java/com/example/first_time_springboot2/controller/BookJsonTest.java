package com.example.first_time_springboot2.controller;

import com.example.first_time_springboot2.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.assertj.core.api.BDDAssertions.then;

@JsonTest
class BookJsonTest {

    @Autowired
    private JacksonTester<Book> json;

    @Test
    public void json_테스트() throws Exception {
        Book book = Book.builder()
                .title("테스트")
                .build();

        String content = "{\"title\":\"테스트\"}";
//        assertThat(this.json.parseObject(content).getTitle()).isEqualTo(book.getTitle());
        assertEquals(this.json.parseObject(content).getTitle(), book.getTitle());
//        assertThat(this.json.parseObject(content).getPublishedAt()).isNull();
        assertNull(this.json.parseObject(content).getPublishedAt());


//        assertThat(this.json.write(book)).isEqualToJson("/test.json");
        then(this.json.write(book)).isEqualToJson("/test.json");
        then(this.json.write(book)).hasJsonPathStringValue("title");
        then(this.json.write(book)).extractingJsonPathStringValue("title").isEqualTo("테스트");
    }

}