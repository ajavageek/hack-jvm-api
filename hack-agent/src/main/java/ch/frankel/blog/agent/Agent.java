package ch.frankel.blog.agent;

import java.lang.instrument.Instrumentation;

public class Agent {

    private Agent() {}

    public static void premain(String args, Instrumentation instrumentation){
        var transformer = new HackTransformer();
        instrumentation.addTransformer(transformer);
    }
}