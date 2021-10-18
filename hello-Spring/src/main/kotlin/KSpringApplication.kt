import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * spring boot의 핵심 클래스
 * MVC web.xml의 기능에 해당하는 클래스
 */
@SpringBootApplication
class KSpringApplication

/**
 * 진입점 함수에서 KSpringApplication 클래스를 사용하여 boot project start
 */
fun main(args: Array<String>) {

//    main은 KSpringApplication이라는 클래스를 가지고 app을 실행함?
    runApplication<KSpringApplication>(*args)
}