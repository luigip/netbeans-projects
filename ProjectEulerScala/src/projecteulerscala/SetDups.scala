
package projecteulerscala

object Dups1 extends App {
  val myMap = Map("iu_1" -> 1, "dbu_2" -> 2, "iu_2" -> 3)
  
  val ints = myMap.keySet.toList.map { _.split("_")(1) }
  val duplicates = ints.foldLeft(Set[String](), Set[String]()){ (a, b) => 
    if(a._1 contains b) (a._1, a._2 + b) else (a._1 + b, a._2) }._2
  println(duplicates)
}

object Dups2 extends App {
  val myMap = Map("iu_1" -> 1, "dbu_2" -> 2, "iu_2" -> 3)
  
  val ints = myMap.keySet.toList.map{_.split("_")(1)}
  val duplicates = ints.map{i => (i, ints.filter{_ == i}.length > 1)}
                .filter{_._2 == true}
                .map{_._1}
                .toSet
  println(duplicates)
}

object Dups3 extends App {
  val myMap = Map("iu_1" -> 1, "dbu_2" -> 2, "iu_2" -> 3)
  
  val ints = myMap.keySet.toList map {_.split("_")(1)}
  val duplicates = ints diff {ints distinct} 
  println(duplicates.toSet)
}

object Dup4 extends App {
  val myMap = Map("iu_1" -> 1, "dbu_2" -> 2, "iu_2" -> 3)
  
  val duplicates = myMap.keySet 
       .groupBy { _.split("_")(1) }    
       .filter { _._2.size > 1 }       
}