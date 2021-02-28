class Sorting {
  // To perform merging
    def mergeSort(list: List[Int]): List[Int] = {
      val n = list.length / 2 // find middle element
      if (n == 0) list
      else {
        // perform sorting on left and right element of list
        def merge(left_list: List[Int], right_list: List[Int]): List[Int] =
          (left_list, right_list) match {
            case(Nil, right_list) => right_list // if left list is empty
            case(left_list, Nil) => left_list  // if right list is empty
            case(x :: left1, y :: right1) =>    // if left and right both have element
              if (x < y) x::merge(left1, right_list)
              else y :: merge(left_list, right1)
          }
         // SplitAt use to divide up the data up each time into a tuple. For every recursion this will new a new tuple.
        val (left, right) = list splitAt(n)
        merge(mergeSort(left), mergeSort(right))
      }
    }

  }
  object Sort{
    def main(args: Array[String]): Unit = {
      val so = new Sorting()
      print(so.mergeSort(List(1,-4,10,8,0)))

    }
  }








