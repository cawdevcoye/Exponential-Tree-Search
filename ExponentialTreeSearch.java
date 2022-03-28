/*
       ______________________________
      /+|Author :              |---/
     /++|  : Chris Williamson  |--/
    /+++|++++++++++++++++++++++|-/




   _________________________________________________________________________________________________
    | Basic Info (Original) |                                                                       |
    |-----------------------------------------------------------------------------------------------|
    |- A Binary Tree has Nodes expressed as Integers through Post Fix Notation                      |
    |- The Tree is an Exponentially Sized Binary Tree, where each Node in the Tree has 2 Children.  |
    |_______________________________________________________________________________________________|


   _________________________________________________________________________________________________
    | Input Data (Original) |                                                                       |
    |-----------------------------------------------------------------------------------------------|
    |- You will receive as Input a height H, and a List of Numbers.                                 |
    |- The Set of Numbers correspond to the Locations of Nodes in the Exponential Tree.             |
    |- The Tree has height h.                                                                       |
    |_______________________________________________________________________________________________|

   _________________________________________________________________________________________________
    | Problem Description (Original) |                                                              |
    |-----------------------------------------------------------------------------------------------|
    |- For each of the Values Provided:                                                             |
    |    : Calculate the Numeric Value of the specified Node's Parent.                              |
    |    : If the Calculated Value DOES-NOT fall within the Numeric bounds of the Tree, Return -1.  |
    |_______________________________________________________________________________________________|
    _______________________
    |   Height Examples   |
    |                     |
    |_____________________|
    | | |    | Height  2  |
    |   |    |            |
    |---|    |____________|
    | |    TREE           |
    |   |        3        |
    | | |       1 2       |
    |---------------------|
    | | |    | Height  3  |
    |   |    |            |
    |---|    |____________|
    | |    TREE  7        |
    |   |      3   6      |
    | | |     1 2 4 5     |
    |---------------------|
    |_____________________|

  __________________________________________________________________________________________________
   |Coordinate Examples:     |-Height-|-Value-|-Coordinate-| <<|                                    |
   |________________________________________________________________________________________________|
   |------|                                                                                         |
   |      |H=3, Value = 6 | Representative of the Right Child of the Root Node.                    :|
   |      |H=3, Value = 2 | Representative of the Right Child of the Left Child of the Root Node.  :|
   |      |H=2, Value = 1 | Representative of the Left Child of the Root Node.                     :|
   |      |H=2, Value = 4 | Representative of Nothing -- Not in the tree.                          :|
   |------|_________________________________________________________________________________________|

  ___________________________________________________________________________________________________
   |Proper Answer Examples: |-Height-|-Value-|-Answer-| <<|                                         |
   |________________________________________________________________________________________________|
   |------|                                                                                         |
   |      |H=3, Value = 6 | Answer : 7                                                             :|
   |      |H=3, Value = 2 | Answer : 3                                                             :|
   |      |H=2, Value = 1 | Answer : 3                                                             :|
   |      |H=2, Value = 4 | Answer : -1                                                            :|
   |      |H=3, Value = 7 | Answer : -1                                                            :|
   |------|_________________________________________________________________________________________|

  __________________________________________________________________________________________________
   | Problem Description (ReLinked/Copied) |                                                        |
   |------------------------------------------------------------------------------------------------|
   | For each of the Values Provided:                                                               |
   |  : Calculate the Numeric Value of the specified Node's Parent.                                 |
   |  : If the Calculated Value DOES-NOT fall within the Numeric bounds of the Tree, Return -1.     |
   |________________________________________________________________________________________________|

    ___________________________
   |Solution:   |  |  |  |  |  |
   |            V  V  V  V  V  |
   |___________________________|
*/


public class ExponentialTreeSearch {

    public void runTest() {
        int Height=31;
        int[] Test_Values = {32, 15, 6, 13, 1, 20, 4, 1073741823};
        //Expected Values = :-1, 31, 7, 14, 3, 21, 6, 2147483647:
        int[] Solution = Solve(Height, Test_Values);
        for (int I =0;I<Test_Values.length;I++)
            System.out.println(": "+Test_Values[I]+" --> "+Solution[I]+" :");
    }
    public int[] Solve(int H, int[] Values) {
        int[] Return_Value = new int[Values.length];
        for (int I = 0; I < Values.length; I++)
            Return_Value[I] = Calculate(Values[I], H);
        return Return_Value;
    }
    public int Calculate(int search_value, int height) {
    	int root_node_value = (Math.pow(2, height) - 1;
        if root_node_value <= search_value)
            return -1;
        int current_height = height;
        int relative_search_coordinate = search_value;
        for (int i = 1; i <= height; i++) {
            int index_into_height = ((int) (Math.log(relative_search_coordinate) / Math.log(2))) + 1;
            int current_value = (int) Math.pow(2, index_into_height) - 1;
            int value_offset = (int) Math.pow(2, index_into_height - 1) - 1;
            int top_of_relational_tree = (int)(Math.pow(2, current_height)) - 1;
            if (current_value == relative_search_coordinate) {
                if (current_value == top_of_relational_tree)
                return search_value + 1;
                return (int) (search_value + Math.pow(2, index_into_height));
            } else {
                relative_search_coordinate -= value_offset;
                current_height = index_into_height - 1;
            }
        }
        return -1;
    }
}
