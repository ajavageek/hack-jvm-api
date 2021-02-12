package ch.frankel.blog.agent;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.NotFoundException;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class HackTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader,
                            String name,
                            Class<?> clazz,
                            ProtectionDomain domain,
                            byte[] bytes) {
        if ("ch/frankel/blog/agent/Private".equals(name)) {
            var pool = ClassPool.getDefault();
            try {
                var cc = pool.get("ch.frankel.blog.agent.Private");
                var method = cc.getDeclaredMethod("implementation");
                method.setBody("{ return \"Agent-hacked implementation!\"; }");
                bytes = cc.toBytecode();
            } catch (NotFoundException | CannotCompileException | IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }
}