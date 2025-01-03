package Jar.com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//@RequiredArgsConstructor 은 필요한 생성자를 자동으로 만들어준다.
@Getter
public class HelloLombok {
    private final String hello;
    private final int lombok;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok("헬로", 5);
        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
    }
}
