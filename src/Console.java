public class Console {

    public void out(String s) {
        System.out.println(s);
    }

    public void outs(String format, Object... args) {
        System.out.printf((String)format, args);
    }



}
