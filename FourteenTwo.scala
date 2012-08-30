package Euler

/**
 * Created with IntelliJ IDEA.
 * User: randyu
 * Date: 5/11/12
 * Time: 9:56 AM
 */

object FourteenTwo {
  def main(a:Array[String]) {
    val startTime = System.currentTimeMillis()

    def from(n: Long, c: Int = 0): Int = if (n == 1) c + 1 else from(if (n % 2 == 0) n / 2 else 3 * n + 1, c + 1)

    val r = (1 until 1000000).view.map(n => (n, from(n)))
      .reduceLeft((a, b) => if (a._2 > b._2) a else b)._1

    val endTime = System.currentTimeMillis()
    println(endTime - startTime + "ms")
    println(r)
  }
}
