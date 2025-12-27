package com.jhipster.blog.domain;

import static com.jhipster.blog.domain.BlogTestSamples.*;
import static com.jhipster.blog.domain.PostTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.jhipster.blog.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class BlogTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Blog.class);
        Blog blog1 = getBlogSample1();
        Blog blog2 = new Blog();
        assertThat(blog1).isNotEqualTo(blog2);

        blog2.setId(blog1.getId());
        assertThat(blog1).isEqualTo(blog2);

        blog2 = getBlogSample2();
        assertThat(blog1).isNotEqualTo(blog2);
    }

    @Test
    void postTest() {
        Blog blog = getBlogRandomSampleGenerator();
        Post postBack = getPostRandomSampleGenerator();

        blog.addPost(postBack);
        assertThat(blog.getPosts()).containsOnly(postBack);
        assertThat(postBack.getBlog()).isEqualTo(blog);

        blog.removePost(postBack);
        assertThat(blog.getPosts()).doesNotContain(postBack);
        assertThat(postBack.getBlog()).isNull();

        blog.posts(new HashSet<>(Set.of(postBack)));
        assertThat(blog.getPosts()).containsOnly(postBack);
        assertThat(postBack.getBlog()).isEqualTo(blog);

        blog.setPosts(new HashSet<>());
        assertThat(blog.getPosts()).doesNotContain(postBack);
        assertThat(postBack.getBlog()).isNull();
    }
}
