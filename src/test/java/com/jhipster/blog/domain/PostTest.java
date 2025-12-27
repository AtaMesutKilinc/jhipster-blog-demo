package com.jhipster.blog.domain;

import static com.jhipster.blog.domain.BlogTestSamples.*;
import static com.jhipster.blog.domain.PostTestSamples.*;
import static com.jhipster.blog.domain.TagTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.jhipster.blog.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class PostTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Post.class);
        Post post1 = getPostSample1();
        Post post2 = new Post();
        assertThat(post1).isNotEqualTo(post2);

        post2.setId(post1.getId());
        assertThat(post1).isEqualTo(post2);

        post2 = getPostSample2();
        assertThat(post1).isNotEqualTo(post2);
    }

    @Test
    void tagTest() {
        Post post = getPostRandomSampleGenerator();
        Tag tagBack = getTagRandomSampleGenerator();

        post.addTag(tagBack);
        assertThat(post.getTags()).containsOnly(tagBack);

        post.removeTag(tagBack);
        assertThat(post.getTags()).doesNotContain(tagBack);

        post.tags(new HashSet<>(Set.of(tagBack)));
        assertThat(post.getTags()).containsOnly(tagBack);

        post.setTags(new HashSet<>());
        assertThat(post.getTags()).doesNotContain(tagBack);
    }

    @Test
    void blogTest() {
        Post post = getPostRandomSampleGenerator();
        Blog blogBack = getBlogRandomSampleGenerator();

        post.setBlog(blogBack);
        assertThat(post.getBlog()).isEqualTo(blogBack);

        post.blog(null);
        assertThat(post.getBlog()).isNull();
    }
}
