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
    val number = readLine()!!.toInt()     // readLint()!! : console 입력 받기, toInt() : 받은 값을 Int로 변환
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
}