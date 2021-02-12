package ch.frankel.blog.reflect;

import ch.frankel.blog.reflect.Private;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.AccessibleObject;

import static org.assertj.core.api.Assertions.assertThat;

public class ReflectionTest {

    private Private priv;

    @BeforeEach
    public void setUp() {
        priv = new Private();
    }

    @Test
    public void shouldAccessPrivateMembers() throws Exception {
        var clazz = priv.getClass();
        var field = clazz.getDeclaredField("attribute");
        var method = clazz.getDeclaredMethod("getAttribute");
        AccessibleObject.setAccessible(new AccessibleObject[]{field, method}, true);
        field.set(priv, "A private attribute whose value has been updated");
        var value = method.invoke(priv);
        assertThat(value).isEqualTo("A private attribute whose value has been updated");
    }
}