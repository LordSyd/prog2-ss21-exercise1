public abstract class BaseHandler implements Handler {
    Handler next;

    public BaseHandler() {
    }

    @Override
    public void setNext(Handler h) {
        this.next = h;
    }

    public boolean handle(String pwToCheck) {
        if (pwToCheck == null) {
            return false;
        }

        if (isValidPassword(pwToCheck)) {
            if (next != null) {
                return next.handle(pwToCheck);
            }
            return true;
        }else {
            return false;}
    }

    public abstract boolean isValidPassword(String pwToCheck);



}
