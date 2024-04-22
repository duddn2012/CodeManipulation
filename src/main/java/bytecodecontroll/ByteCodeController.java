package bytecodecontroll;/*
Byte Code 조작 툴
1. ASM: 자바 클래스 파일 포맷에 대한 이해 필요. visitor 패턴을 통해 구현해야함. API가 복잡하여 사용하기 까다로움
2. Javassist
3. ByteBuddy

바이트코드 조작 툴 활용 예
- 프로그램 분석
1. 코드에서 버그 찾는 툴
2. 코드 복잡도 계산
-클래스 파일 생성
1. 프록시 -> 원래 코드 대신 실행할 프록시 ex) mock 객체 또는 스프링 AOP, Lazy Loading 대상
2. 특정 API 호출 접근 제한
3. 스칼라 같은 언어의 컴파일러
그밖에도 자바 소스 코드 건드리지 않고 코드 변경이 필요한 여러 경우
1. 프로파일러 - 메모리 사용량, 스레드 갯수, 성능 분석 툴
2. 최적화
3. 로깅

스프링이 컴포넌트 스캔을 하는 방법(asm)
1. 컴포넌트 스캔으로 빈으로 등록할 후보 클래스를 찾는데 사용
2.
 */

import static net.bytebuddy.matcher.ElementMatchers.named;

import java.io.File;
import java.io.IOException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

public class ByteCodeController {

    public static void main(String[] args) {
        try {
            //이 시점에 이미 Moja.class를 읽었으므로 class 파일을 수정하더라도 다시 클래스 로딩을 하지 않기 때문에 적용되지 않는다.
            new ByteBuddy().redefine(Moja.class)
                .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
                .make().saveIn(new File("D:\\Project\\theJava\\build\\classes\\java\\main"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(new Moja().pullOut());

    }
}
