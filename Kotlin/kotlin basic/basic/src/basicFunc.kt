// 함수 구조
// fun 함수명(파라미터명: 파라미터 타입): 반환 타입 { to do }
// 파라미터 앞에는 var, val 선언 불가
// 파라미터는 val 로 강제 선언됨
fun Sum(a: Int, b: Int): Int
{
    // 파라미터는 불변, 즉 val 로 선언되기 때문에 함수 내부에서 값을 변경할 수 X
    // a++;
    return a+b;
}

// 반환 값이 void 타입일 때, kotlin 에서는 Unit 타입으로 반환
fun Hi(name: String):Unit
{
    println("Hi, $name");
}

// 함수의 바디 부분이 단일 식일 경우, 다음과 같이 표현 가능
fun Square(a: Int): Int = a * a

// 함수 오버로딩 가능
fun multi(a: Int, b: Int): Int = a * b
fun multi(a: Double, b: Double): Double = a * b

// 파라미터에 디폴트값 제공 가능
fun div(a: Int, b: Int = 10): Int = a / b

// varage 를 사용해 파라미터 개수를 정하지 않고 파라미터를 받을 수 있음
fun printSorted(vararg items: Int): Unit
{
    items.sort()
    println(items.contentToString())
}

fun change(items: IntArray)
{
    items[0] = 100
}

fun main()
{
    // spread 연산자 : *
    // 배열의 값을 복사함 (깊은 복사)
    val a = intArrayOf(6, 3, 10, 1)
    printSorted(*a)
    println(a.contentToString())

    // 참조가 복사됨 (얕은 복사)
    val b = intArrayOf(2, 7, 4, 1)
    change(b)
    println(b.contentToString())

    // 조건문
    // 다음과 같이 식으로 사용할 수 있음
    fun Max (a: Int, b: Int): Int = if( a > b ) a else b
    println("MAX : ${Max(1, 3)}")
    fun Min (a: Int, b: Int): Int = if (a > b) a else if (a == b) 1 else b  // else if 를 사용하고 싶을 때 이와 같이 사용
    println("Min : ${Min(3, 1)}")

    // 식으로 쓰는 if문 예제
    val string = "120/10"
    val index = string.indexOf("/")     //string.indexOf() : 문자열 내 찾으려는 첫번째 특정 문자의 인덱스 반환
    val result = if (index >= 0)
    {
        val a = string.substring(0, index).toInt()              //string.substring() : (인덱스 범위) 만큼 문자열 자르기
        val b = string.substring(index + 1).toInt()
        (a / b).toString()
    } else ""
    println("result : $result")

    // interval 표현
    // 비교 가능한 모든 타입에 대해 .. 사용하여 범위 표현 가능
    for(i in 'a' .. 'd')    //'a'부터 'd'까지의 모든 문자
    {
        println(".. : $i ")
    }

    // until 값 : 정수 타입만 가능, 값 - 1까지의 범위 표현
    for(i in 1 until 10)   // 1부터 9까지의 수. '1..9' 와 동일한 표현
    {
        println("until : $i ")
    }

    // step 값 : 간격(값) 만큼 증가하고 있는 정수나 char의 시퀀스, 간격은 양수여야 함
    for(i in 1 .. 10 step 3)
    {
        println("step : $i")
    }

    // downTo 값 : 간격(값) 만큼 감소하고 있는 정수나 char의 시퀀스, 간격은 양수여야 함
    for(i in 20 downTo 9 step 5)
    {
        println("downTo : $i")
    }

    // in 연산자 : 해당 범위에 있는지 체크 후 bool 값 반환. !in 사용 가능
    println("in 연산자 test ( 정수 입력 ) : ")
    val number = readLine()!!.toInt()
    // readLint() : console 입력 받기, !! : 입력받은 값이 null 이 아님을 알려줌, toInt() : 받은 값을 Int로 변환
    println(number in 10 .. 99)

    val text = "message"
    println("a in : " + 'a' in text)    // 범위 뿐만 아니라 원소를 가지는 타입일 때도 지원

    // 범위를 이용하여 문자열이나 배열의 일부를 뽑아낼 수 있음
    println("Hello, my name is ~".substring(1..3))  // 출력값 : ell

    // 우선순위
    // +, - << .. << and, or, until, downTo, step << in, !in << 비교 연산자

    // when문
    // 조건 -> 문 형태 + else -> 문 형태
    // 최초로 참으로 평가되는 조건을 찾고 그 조건에 대응하는 문을 실행, 없다면 else 문 실행
    // 모든 예외를 생각하여 하나의 조건문이라도 부합하도록 예외 처리에 신경 써줘야 함
    fun ScoreManagement(score: Int, max: Int): String = when(score)
    {
        in 95 .. max -> "A+"
        in 90 until 95 -> "A"
        in 85 until 90 -> "B+"
        in 80 until 95 -> "B"
        1, 2, 3, 4, 5 -> "D+"   // 각각의 조건들은 Or 연산 취급
        else -> "F"
    }
    print("ScoreManagement : ")
    println(ScoreManagement(98, 100))

    // label example : 루프를 제어하기 위해 사용됨
    // 레이블명@ ~ @레이블명
    fun list()
    {
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return // 가장 가까운 함수인 list() 함수 탈출
            print(it)
        }
        println("unreachable")
    }
    list()
    println()

    fun forEachWithLabel()
    {
        listOf(1, 2, 3, 4, 5).forEach list@ {
            if (it == 3) return@list   // list@ 레이블의 각 루프 탈출, 즉, 3에서 탈출하고 4, 5 진행
            print(it)
        }
        println(" : explicit label")
    }
    forEachWithLabel()

    fun nestedLambdaWithLabel()
    {
        run loop@ {
            listOf(1, 2, 3, 4, 5).forEach {
                if(it == 3) return@loop     // loop@ 레이블 블록 탈출
                print(it)
            }
        }
        print( " : nested Lambda label")
        println()
    }
    nestedLambdaWithLabel()

    // tail recursive : 비재귀적인 코드로 자동 변환, 재귀함수에 대한 최적화 컴파일을 위함
    // tail recursive 가 가장 마지막으로 호출되며 함수가 끝나야 함
    tailrec fun factorial(n: Int, mul: Int = 1): Int
    {
        val fac = n * mul
        return if (n <= 1 ) fac else factorial(n - 1, fac)
    }
    println("factorial : ${factorial(10)}")

    // throw exception : 예외의 경우 오류를 발생시키도록
    // throw : return type 은 Nothing 타입
    // catch 구문 : 예외를 잡아 처리함
    println("throw exception 예제 -- ")
    println("수 입력 : ")
    var num = readLine()!!.toInt()
    if (num in 1 until 10) println("한 자리 수")
    else throw NumberFormatException("한 자리 수가 아님")

    // try-catch 문
    // try : 예외가 발생할 수 있는 코드가 담긴 블록 (식으로 사용 가능)
    // catch : 예외를 처리할 수 있는 블록, 선언된 순서대로 예외 타입 검사
    // final : try 블록을 떠나기 전에 실행, 주로 파일 닫기, 네트워크 파일 닫기 등의 일을 수행하게 함
    fun readNumber (): Int {
        try {
            println("try-catch 문 예제 -- ")
            print("정수 입력 : ")
            val inputNumber = readln().toInt()
            return inputNumber
        } catch (e: java.lang.NumberFormatException) {
            return -1
        } finally {
            println("final block")
        }
    }
    println("readNumber : ${readNumber()}")

    // try 문을 식으로 사용했을 때 finally 블록의 값은 try 블록의 값에 영향 X
    fun readInt (): Int? = try {
        readLine()!!.toInt()
    } catch (e: NumberFormatException) {
        -1
    }

    println("try-catch 문 예제 2 -- ")
    print("readInt : ${readInt()}")

}