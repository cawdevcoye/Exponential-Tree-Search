Author: Chris W
# Exponential Tree Search

In the field of Combinatorics, finding solutions to specific problems is usually quite complicated. There isnt a single algorithm to find a given solution to an arbitrary combinatorial problem, and as such, finding fast solutions to unique combinatorial problems require domain specific algorithms. In general, these algorithms are based on unique properties associated with a given question, where the process of building a polynomial time algorithm revolves around utilizing those properties and building a solution with them. For particularly tricky problems, the process may require finding novel properties to utilize. 

The Exponential Tree Search algorithm was designed through the process of building a domain specific solution to a search problem, and is an example of a domain specific solution to a combinatorial problem. 

This algorithm solves a question associated with 

# Problem
This algorithm solves a problem tha formally asks for the label of the parent node of a given node in an exponential tree. The labeling description of nodes is in the document. 

# High Level Description
This solution uses a Double-Ended search algorithm based on searching from a defined start location and a defined goal location in tandem. This script also works by looking through a set of nodes at once, rather than looking at nodes individually. The tandem search process is based on redefining the search criteria while the search is taking place, and uses the deterministic changes made to the search criteria to cast a discovered solution from the redefined criteria back to the original criteria, where the full solution computation can be made.
This process works as follows: Start at a defined initial location, maintain a desired goal state -> Test start conditions, check for goal state, update goal state, repeat until goal state found. 

The consequences of this solution are as follows: Demonstrates feasibility of searching sets of information in time equal to searching a single piece. Demonstrates potentially unique process of searching from an origin point and a specified goal state in tandem, which is useful for discovering a traversal from a start to an end state. 

# Details
Search Criteria : Provided as a parameter -> The node whos parent node must be found. 
Relative Search Coordinate: The updated Search Criteria
Value Offset: An offset used to update the Search Criteria

Calculate Function:
  It parses the set of nodes defined as the recursive set of left child nodes starting at the root node. This set of nodes is the defined initial search set (Not explicitly represented in the code). This parse process performs a single calculation which represents a search of multiple sets of information. This parse is a base 2 Logarithm, and is performed against the current search value. A base 2 logarithm is used as the recursive-left set of nodes are all based on exponentiation. This calculation (Log2 +1 of current search criteria) yields the root node of a new tree to search for the criteria in. If the numeric label of the new height variable is not equal to the relative search criteria (which initially is the provided search criteria), then a tree of height=(calculated value) is utilized, and the search criteria is updated through an offset. This offset has the effect of taking the initial/current tree (tree also not explicitly represented in the code), and updating the criteria such that the relative location of the original search criteria is maintained in the new tree. This process repeats until the currently tested value (Through the logarithm calculation) is equal to the relative search criteria/coordinate, where a formula to calculate the solution is used. 
  
# Numbers
  Height: h
# Properties
  Root Node: Root has label 2^(h) -1
  
  Node_Label: Is some number
  
  Recusive Left Node Set: 
    Starting at root, ending at last left child
    
    left_child_label = ((cur_node_label +1 )/2)-1 
    Parent_Node_Label = ((cur_node_label + 1)*2)-1
    For each Node: Recursive Right Child Parse 
    (Each Recursively parsed node's label is cur_node - 1)
    So the right-right child of a node in this set is cur_node -1 -1. 
    
      
    
More To Write Later :D
