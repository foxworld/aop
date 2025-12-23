package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV0 {

    public void external() {
        log.info("call external");
        internal();
        // 내부 메서드 호출(this.internal()와 동일)
        // AOP 프록시를 거치지 않고 내부 메서드가 호출된다.
        // 따라서 internal 메서드에는 AOP가 적용되지 않는다.
        // 해결 방법은 CallServiceV1을 참고
        // CallServiceV0 callServiceV0 = applicationContext.getBean(CallServiceV0.class);
        // callServiceV0.internal();
        // 이렇게 하면 AOP 프록시를 거쳐서 internal 메서드가 호출된다.
        // 하지만 이 방법은 권장되지 않는다.
        // 내부 메서드 호출이 많아지면 코드가 복잡해지고 유지보수가 어려워진다.
        // 또한, applicationContext를 주입받아야 하는 번거로움도 있다.
        // 따라서 내부 메서드 호출에 AOP를 적용해야 한다면 별도의 클래스로 분리하는 것이 좋다.
        // CallServiceV1을 참고
        // ex) CallServiceV1 내부에 internal 메서드를 분리
        // callServiceV1.internal();
        // 이렇게 하면 AOP 프록시를 거쳐서 internal 메서드가 호출된다.
        // 또한, 코드도 간결해지고 유지보수도 쉬워진다.
        // applicationContext 주입도 필요없다.
        // 이 방법이 가장 권장되는 방법이다.
        // 참고: Spring AOP는 기본적으로 같은 클래스 내의 메서드 호출에는 AOP가 적용되지 않는다.
        // 이는 프록시 기반 AOP의 한계 때문이다.
        // 내부 메서드 호출에도 AOP를 적용하려면 AspectJ와 같은 바이트코드 조작 기반 AOP를 사용해야 한다.
        // 하지만 AspectJ는 설정이 복잡하고 성능에 영향을 줄 수 있으므로 신중히 선택해야 한다.
        // 대부분의 경우에는 내부 메서드 호출에 AOP를 적용할 필요가 없으므로
        // 위에서 설명한 방법으로 충분하다.
        // 상황에 맞게 적절한 방법을 선택하여 사용하면 된다.
        // 요약: 내부 메서드 호출에 AOP를 적용하려면 별도의 클래스로 분리하는 것이 가장 권장되는 방법이다.
    }

    public void internal() {
        log.info("call internal");
    }
}
