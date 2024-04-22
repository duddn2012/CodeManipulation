package spring;/*

클래스 로더 시스템 : 로딩, 링크, 초기화
로딩: .class에서 바이트코드를 읽고 메모리에 저장
링크: 레퍼런스를 연결하는 과정
초기화: static 값을 초기화 및 변수에 할당

메모리: 스택, PC, 네이티브 메소드 스택, 힙, 메소드
메소드 영역: 클래스 수준의 정보를 저장(클래스 이름, 부모 클래스 이름, 메소드 변수) 공유 자원이다.
힙 영역: 객체를 저장, 공유 자원이다. -> 클래스 로딩만 해도 클래스 객체가 만들어진다.
나머지 스택 ,PC, 네이티브 메소드 스택 영역들은 스레드에 국한된다.
PC 레지스터에 현재 어떤 메소드를 실행하고 있는지 저장하고 있는다.
네이티브 메소드 스택: 네이티브 메소드를 호출할 때 사용
네이티브 메소드 -> Java가 아닌 다른 언어로 만든 메소드
public static native Thread currentThread();
JNI(Java Native Interface): 자바 어플리케이션에서 C, C++, 어셈블리로 작성된 함수를 사용할 수 있는 방법 제공
Native 키워드를 사용한 메소드 호출

실행 엔진
- 인터프리터: 바이트 코드를 한줄 씩 실행.
- JIT 컴파일러: 인터프리터 효율을 높이기 위해, 인터프리터가 반복되는 코드를 발견하면 JIT 컴파일러로 반복되는 코드를 모두 네이티브 코드로 바꿔둔다.
그 이후로는 인터프리터는 네이티브 코드로 컴파일된 코드를 바로 사용한다.

클래스 로더 시스템

 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Start {

    public static String myName;

    static {
        myName = "youngwoo";
    }
    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
        System.out.println(Start.class.getSuperclass());
    }
}
