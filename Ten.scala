package Euler

//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//Find the sum of all the primes below two million.
//A: 142913828922    //2834ms w/ 900mb
object Ten {
  def main(a:Array[String]){
    val s = System.currentTimeMillis()
//    def bigInts(n:BigInt):Stream[BigInt] = Stream.cons(n, bigInts(n+1))

//    lazy val ps: Stream[BigInt] = BigInt(2) #:: bigInts(3).filter(i =>
    lazy val ps: Stream[Int] = 2 #:: Stream.from(3).filter(i =>
      ps.takeWhile(j => j * j <= i).forall(i % _ > 0)
    )
    val primes = ps.takeWhile(_<2*1000*1000)  //2,147,483,647
//    println(primes.sum)
//    primes.foreach(println)
    val tot = primes.foldLeft(BigInt(0))((a,x)=>{
      a+BigInt(x)
    })

//    val tot = primes.foldLeft(0l)(_+_)
//      println(primes)
    println(tot)


    val e = System.currentTimeMillis()
    print(e - s + "ms")
  }
}
