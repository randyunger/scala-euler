package Euler

/*



Starting in the top left corner of a 2×2 grid, there are 6 routes (without backtracking) to the bottom right corner.

How many routes are there through a 20×20 grid?


 */

object Fifteen {
  def main(a:Array[String]){
    val hw = 20
////    val area = hw * hw
    val numOfEach = hw*1 //(area / 2)
    val list =  Stream.continually("1").take(numOfEach).toList ++ Stream.continually("0").take(numOfEach).toList
    val perms = list.permutations
//    println(perms.size)
    var i = 0
    perms.foreach(x=>{
      println(i + "\t" + x)
      i+=1
    })
    println(i)

//
////    val x = Integer.parseInt("11111111110000000000", 2)
//    val x = BigInt(list.mkString, 2)
//
//    def cCount(s: String, c: Char) = s.filter(_ == c).length
//
//    def makeBStr(n:BigInt) = {
//      var r = n.toString(2)
//      while(r.length < hw*2) r = "0"+r
//      r
//    }
//
//    val paths = (BigInt(1) to x).filter(n => {
//      val bStr = makeBStr(n)
//      cCount(bStr,'0') == cCount(bStr, '1')
//    })
//
//    paths.foreach(n => {
//       println(makeBStr(n))
//    })
//
//    println(paths.length)

  }
}
