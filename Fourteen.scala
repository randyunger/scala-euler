package Euler

import annotation.tailrec
import collection.mutable

/*
The following iterative sequence is defined for the set of positive integers:

n  n/2 (n is even)
n  3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13  40  20  10  5  16  8  4  2  1
12  6    3  10  5  16  8  4  2  1
11
10
9
8
7
6
5  16  8   4  2  1
4  2   1
3  10  5  16  8  4  2  1
2  1
1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
 */

//A: 837799 //10708ms
//The BigInts seem to slow this down? Yes, by a factor of 5+! Longs: 1706ms

object Fourteen {
  def main(a: Array[String]) {
    val startTime = System.currentTimeMillis()

    var curr = (0l, 0)

    //    val max = (1000000 to 2 by -1).map(i=> {
    //      (i, chain(i).length)
    //    }).sortBy(_._2).last
    (500003 to 1000000 by 2).foreach(i => {
      val len = chainLength(i)
      //      println("\n"+ i + "->"+ len + "\n")
      if (len > curr._2) curr = (i, len)
    })

    val endTime = System.currentTimeMillis()
    println(endTime - startTime + "ms")
    //    println(map)
    println(curr)
    println(curr._1)
  }

//  val map: mutable.Map[Long, Long] = mutable.Map(1l -> 1l)

    @tailrec
  def chainLength(n: Long, len: Int = 1): Int = {
    //    print("::"+n+","+len)
    val next = {
      if (n % 2 == 0) n / 2
      else 3 * n + 1
    }

    if (n==1)  len



//    if (map.contains(next)) {
//      val l = map(next) + 1
//      map += (n -> l)
//      l + len - 1
//    }
    else chainLength(next, len + 1)
    //    map.keys.toList.sorted
  }
}



//object Fourteen {
//  def main(a: Array[String]) {
//    val startTime = System.currentTimeMillis()
//
////    var curr = (BigInt(0), BigInt(0))
//
//        val max = (20 to 2 by -1).map(i=> {
//          (i, chainLength(i))
//        }).sortBy(_._2).last
//
//    val curr = max
////    (2 to 1000000).foreach(i => {
////      val len = chainLength(i)
////      println("\n"+ i + "->"+ len + "\n")
////      if (len > curr._2) curr = (i, len)
////    })
//
//    val endTime = System.currentTimeMillis()
//    println(endTime - startTime + "ms")
////    println(map)
//    println(curr)
//    println(curr._1)
//  }
//
////  val map: mutable.Map[BigInt, BigInt] = mutable.Map(BigInt(1) -> BigInt(1))
//
////  @tailrec
//  def chainLength(n: Long, len: Long=1): Long = {
//    print("::"+n+","+len)
//    val next = {
//      if (n % 2 == 0) n/2
//      else 3 * n + 1
//    }
//
//    if(n==1) len
//
////    if (map.contains(next)){
////      val l = map(next) + 1
////      map += (n -> l)
////      l + len - 1
////    }
//    else chainLength(next, len+1)
////    map.keys.toList.sorted
//  }
//}

//object Fourteen {
//  def main(a: Array[String]) {
//    val startTime = System.currentTimeMillis()
//
//    val endTime = System.currentTimeMillis()
//    println(endTime - startTime + "ms")
//  }
//}

//object Fourteen {
//  def main(a: Array[String]) {
//    val startTime = System.currentTimeMillis()
//
//    var curr = (BigInt(0), BigInt(0))
//
//    //    val max = (1000000 to 2 by -1).map(i=> {
//    //      (i, chain(i).length)
//    //    }).sortBy(_._2).last
//    (2 to 1000000).foreach(i => {
//      val len = chainLength(i)
////      println("\n"+ i + "->"+ len + "\n")
//      if (len > curr._2) curr = (i, len)
//    })
//
//    val endTime = System.currentTimeMillis()
//    println(endTime - startTime + "ms")
////    println(map)
//    println(curr)
//    println(curr._1)
//  }
//
//  val map: mutable.Map[BigInt, BigInt] = mutable.Map(BigInt(1) -> BigInt(1))
//
////  @tailrec
//  def chainLength(n: BigInt, len: BigInt=1): BigInt = {
////    print("::"+n+","+len)
//    val next = {
//      if (n % 2 == 0) n/2
//      else 3 * n + 1
//    }
//
//    if (map.contains(next)){
//      val l = map(next) + 1
//      map += (n -> l)
//      l + len - 1
//    }
//    else chainLength(next, len+1)
////    map.keys.toList.sorted
//  }
//}


//object Fourteen {
//  def main(a:Array[String]) {
//    val startTime = System.currentTimeMillis()
//
//    var curr = (0,0)
//
////    val max = (1000000 to 2 by -1).map(i=> {
////      (i, chain(i).length)
////    }).sortBy(_._2).last
//    (100000 to 2 by -1).foreach(i => {
//      val c = chain(i)
//      if(c.length > curr._2) curr = (i,  c.length)
//    })
//
//    val endTime = System.currentTimeMillis()
//    println(endTime - startTime + "ms")
//
//    println(curr)
//    println(curr._1)
//  }
//
//  @tailrec
//  def chain(n:Int, ch:Seq[Int]=Nil):Seq[Int] = {         //Cache
//    if (n==1) {
////      println(ch)
//      n +: ch
//    }
//    else if (n%2==0) chain(n / 2, n +: ch)
//    else chain(3*n+1, n +: ch)
//  }
//}


//object Fourteen {
//  def main(a: Array[String]) {
//    val startTime = System.currentTimeMillis()
//
//    var curr = (0, 0)
//
//    //    val max = (1000000 to 2 by -1).map(i=> {
//    //      (i, chain(i).length)
//    //    }).sortBy(_._2).last
//    (100000 to 2 by -1).foreach(i => {
//      val c = chainLength(i)
//      if (c > curr._2) curr = (i, c)
//    })
//
//    val endTime = System.currentTimeMillis()
//    println(endTime - startTime + "ms")
//
//    println(curr)
//    println(curr._1)
//  }
//
//  val map: mutable.Map[Int, Int] = mutable.Map(1 -> 1)
//
//  @tailrec
//  def chainLength(n: Int, ch: Seq[Int] = Nil): Int = {
//    //Cache
//    if (map.contains(n)) map(n)
//    else if (n % 2 == 0) chain(n / 2, n +: ch)
//    else chain(3 * n + 1, n +: ch)
//  }
//}