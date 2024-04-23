package reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 기본적으로 어노테이션은 주석이기 때문에 컴파일된 class 파일까지는
 * 어노테이션 정보가 들어가지만 바이트 코드를 로딩했을 때 즉, 런타임 시점에는 제외된다.
 * 이를 런타임 시에도 유지하기 위해서는 @Retention 설정을 통해 유지시킬 수 있다.
 *
 * @Target을 통해 어노테이션을 사용할 수 있는 경우를 지정할 수 있다.
 *
 * 어노테이션은 제한된 타입의 값을 가질 수 있다.
 * 가령 primitive 타입은 불가능하지만, Integer, String 와 같은 Wrapper 타입은 가능하다.
 * value()로 정의될 경우 어노테이션 사용 시 value = "" 를 생략 가능하다. @MyAnnotation("end")
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface MyAnnotation {

    String value() default "start";
    String name() default "youngwoo";



}
