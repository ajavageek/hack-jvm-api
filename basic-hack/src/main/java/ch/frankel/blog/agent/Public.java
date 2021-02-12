package ch.frankel.blog.agent;

public class Public {

    private final Private priv;

    public Public() {
        this.priv = new Private();
    }

    public String entryPoint() {
        return priv.implementation();
    }
}