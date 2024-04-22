package bytecodecontroll;/*
Byte Code 조작 툴
1. ASM: 자바 클래스 파일 포맷에 대한 이해 필요. visitor 패턴을 통해 구현해야함. API가 복잡하여 사용하기 까다로움
2. Javassist
3. ByteBuddy
 */

import static net.bytebuddy.matcher.ElementMatchers.named;

import java.io.File;
import java.io.IOException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

public class ByteCodeController {

    public static void main(String[] args) {
        try {
            new ByteBuddy().redefine(Moja.class)
                .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
                .make().saveIn(new File("D:\\Project\\theJava\\build\\classes\\java\\main"));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println(new Moja().pullOut());

    }
}
