package Euler

import annotation.tailrec

/*A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/
//A:31875000  //433ms
object Nine {
  val num = 1000

  def main(args:Array[String]) {

    val start = System.currentTimeMillis()
    var found = false
    var a=1
    while(!found && a<1000){
      a+=1
      var b=1
      while(!found && b<1000){
        b+=1
        var c=1
        while(!found && c<1000){
          c+=1
          if (a*a+b*b==c*c && a+b+c==num){
            found = true
            println(a*b*c)  //433ms
          }
        }
      }
    }



//    val triples = for (a <- 1 to num
//    ;b<- 1 to num
//    ; c<- 1 to num
//      if(a*a+b*b==c*c && a+b+c==num)
//    ) yield ((a,b,c))
//    {
//      println (a,b,c +":"+a*b*c) //10071ms
//
//    }
//    println(triples)
//    val first = triples.head
//    val ans = first._1 * first._2 * first._3

    val end = System.currentTimeMillis()
//    println(ans)

    println(end - start + "ms") //12343 ms

//    def nats(n: BigInt):Stream[BigInt] = Stream.cons(n, nats(n+1))
//    val sqrs = nats(0).map(i => (i,i * i)).takeWhile(_._1 < 1000)
//    sqrs.foreach(println)


  }
}

