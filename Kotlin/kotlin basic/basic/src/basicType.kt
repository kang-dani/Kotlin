import java.util.Date

fun main() {
    // var 키워드로 변수 정의
    // var 변수명 = 값 초기화
    // 자동으로 변수 타입을 추론하여 타입 명시 필수가 아님
    // 변수는 call-by-value 타입. 즉, 값을 복사해서 전달 받음
    var a = 1
    var b = "Hi"
    var c = 12.32
    var d = 'a'

    //mutable type
    // 필요할 경우에 타입 명시 가능
    // var 변수명: 타입 = 값
    var n: Int = 100
    var s: String = "Hello"

    // immutable type
    // 값이 변경되지 않을 때, 즉 상수인 키워드
    // val 상수명 = 값, or val 상수명: 타입 = 값
    // 초기화 후 값 변경이 불가하나, 변수의 ref 가 가르키는 객체의 내부 값은 변경 가능.
    val name = "kang-dani"
    val age: Int = 20

    // Any type
    // null 을 허용하지 않는 모든 코틀린의 type은 any의 하위 타입임
    // 하위 타입 : A가 B의 하위 타입일 때, B 타입의 값이 쓰일 수 있는 모든 문맥에 A 타입의 값을 넣어도 문제가 없음
    val an: Any = 1

    // 문자열
    var strings = """
        Hi, my name is kang-dani.
        my age is 20.
        bye.
        """

    var string = "Hi " + "my name " + "is " + "daeun"
    // 각각 ""로 구분된 string 의 index 에 접근할 수 있음
    println(string[0])

    // 문자열 보간
    // $ 기호를 통해 표현식 포함 가능
    // Data() 사용시 코드 상단에 import java.util.Date 필요
    println("my profile : $string")
    println("Hello, Today is ${Date()}")

    // 배열
    // 제네릭 하기 때문에 원소의 타입을 추론할 수 있도록 값을 넣거나, 값을 명시해줘야 함
    // call-by-ref 타입, 데이터에 대한 참조만 복사됨
    var array = emptyArray<Int>()               // 빈 정수형 배열
    var arrayString = arrayOf("Hi", "world")    // 원소가 "Hi", "world" 인 string 배열

}