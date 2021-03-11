public interface Handler {
    void setNext(Handler h);
    boolean handle(String pwToCheck);
    boolean isValidPassword(String pwToCheck);

}
