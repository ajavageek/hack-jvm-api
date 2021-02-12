package ch.frankel.blog.aspect;

public aspect Hack {

    pointcut privateImplementation(): execution(java.lang.String ch.frankel.blog.aspect.Private.implementation());

    String around(): privateImplementation() {
        return "AOP-hacked implementation!";
    }
}