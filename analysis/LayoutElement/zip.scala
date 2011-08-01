/*
def beside(that: Element): Element = {
  val contents = new Array[String](this.contents.length)
  for (i <- 0 until this.contents.length)
    contents(i) = this.contents(i) + that.contents(i)
  new ArrayElement(contents)
}

vs

new ArrayElement(
    for ((line1, line2) <- this1.contents zip that1.contents)
    yield line1 + line2
)
*/
def beside(one: Array[String], two: Array[String]) : Array[String]= {
  //new Array[String] (
    for ((line1, line2) <- one zip two)
    yield line1 + line2
  //)
}
val firstArray = Array("1","2","3");
val secondArray = Array("a","b","c");
for(arg <- beside(firstArray,secondArray))
	print(arg + '\n')
//print(beside(firstArray, secondArray))

//print(firstArray zip secondArray);


/* terminal
Welcome to Scala version 2.9.0.1 (Java HotSpot(TM) Server VM, Java 1.6.0_26).
Type in expressions to have them evaluated.
Type :help for more information.

scala> val firstArray = Array("1","2","3")
firstArray: Array[java.lang.String] = Array(1, 2, 3)

scala> val secondArray = Array("a","b","c")
secondArray: Array[java.lang.String] = Array(a, b, c)

scala> firstArray zip secondArray
res0: Array[(java.lang.String, java.lang.String)] = Array((1,a), (2,b), (3,c))

scala> for((line1, line2) <- firstArray zip secondArray) yield line1 + line2
res2: Array[java.lang.String] = Array(1a, 2b, 3c)
*/
