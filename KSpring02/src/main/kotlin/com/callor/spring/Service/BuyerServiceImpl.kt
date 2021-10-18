import com.callor.spring.service.BuyerService
import model.Buyer
import org.springframework.stereotype.Service
import kotlin.random.Random


/**
 * BuyerService interface 를 implement 하여 클래스 선언
 */
@Service
class BuyerServiceImpl : BuyerService {

    val rnd = Random(System.currentTimeMillis())

    /**
     * Kotlin 클래스 내에서 선언되며
     * 클래스가 작동되는데 필요한 필수 데이터나
     * 어떤 옵션을 초기화 하는 초기화 블럭 객체
     */
    companion object {
        // Map 데이터 생성하기
        val user = Pair("name", "홍길동")
        var id = Pair("id", "user")
        val age = Pair("age", 30)

        /**
         * Buyer DTO를 사용하여 3명의 데이터를 선언하고
         * List배열로 생성되었다.
         */
        val userList = arrayOf(
            Buyer(id="admin", name="홍길동", age=30),
            Buyer(id="user", name="이몽룡", age=20),
            Buyer(id="guest", name="성춘향", age=16),
        )
    }


    override fun selectAll():Array<Buyer> {
        return userList
    }

    override fun findById(id: String):Buyer {
        val num = rnd.nextInt()
        return Buyer(id="admin", name="이몽룡", age=30)
    }

}