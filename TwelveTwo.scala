package Euler

/**
 * Created with IntelliJ IDEA.
 * User: randyu
 * Date: 5/2/12
 * Time: 11:55 AM
 */

object TwelveTwo {
  def main(a:Array[String]) = {
    val s = System.currentTimeMillis()
    lazy val ts: Stream[Int] =
      0 #:: ts.zipWithIndex.map(p => p._1 + p._2 + 1)

    def p(t: Int) = Range(1, Int.MaxValue)
      .takeWhile(n => n * n <= t)
      .foldLeft(0)((s, n) => if (t % n == 0) s + 2 else s)

    val r = ts.find(p(_) > 500).get
    println(r)
    val e = System.currentTimeMillis()
    print(e - s + "ms")
  }

}
