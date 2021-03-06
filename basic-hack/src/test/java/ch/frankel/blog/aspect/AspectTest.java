package ch.frankel.blog.aspect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AspectTest {

    private Public pub;

    @BeforeEach
    public void setUp() {
        pub = new Public();
    }

    @Test
    public void shouldHackPrivateImplementation() {
        var value = pub.entryPoint();
        assertThat(value).isEqualTo("AOP-hacked implementation!");
    }
}