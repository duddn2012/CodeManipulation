package reflection;

@MyAnnotation("end")
public class Book {

    @MyAnnotation
    private String a = "a";
    private static String B = "BOOK";
    private static final String C = "BOOK";

    public String d = "d";

    protected  String e = "e";

    public Book() {
    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("F");
    }

    public void g() {
        System.out.println("g");
    }

    public Integer h() {
        return 100;
    }

    public int sum(int left, int right) {
        return left + right;
    }
}
