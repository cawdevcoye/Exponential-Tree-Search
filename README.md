Author: Chris W
# Exponential Tree Search

In the field of Combinatorics, finding solutions to specific problems is usually quite complicated. There isnt a single algorithm to find a given solution to an arbitrary combinatorial problem, and as such, finding fast solutions to unique combinatorial problems require domain specific algorithms. In general, these algorithms are based on unique properties associated with a given question, where the process of building a polynomial time algorithm revolves around utilizing those properties and building a solution with them. For particularly tricky problems, the process may require finding novel properties to utilize. 

The Exponential Tree Search algorithm was designed through the process of building a domain specific solution to a search problem, and is an example of a domain specific solution to a combinatorial problem. 

This algorithm solves a Coding Challenge for Google FooBar, and I dont know much about what its potential applications are. 

# Problem
This algorithm solves a problem that formally asks for the label of the parent node of a given node in an exponential tree. The labeling description of nodes is based on Post-Order Traversals, where each node is labeled based on the order in which nodes are parsed through PostOrder search. 
Examples are in the File. 


# High Level Description
This solution uses a Double-Ended search algorithm based on searching from a defined start location and a defined goal location in tandem, while also parsing groups of nodes at once using their properties. That process has the effect of looking through a set of nodes at once, rather than looking at nodes individually. The tandem search process is based on redefining the search criteria while the search is taking place. It uses the deterministic changes made to the search criteria -while searching for the criteria- to find a solution. Then, based on the redefined criteria, it casts information gained during this process back to the original criteria where the full solution computation can be made.
This process works as follows: Start at a defined initial node set with a desired goal state -> Test initial set, check it the goal criteria is present -> IF not: update goal state and repeat | If So: Use information gained to calculate solution.  

The consequences of this process are as follows: 
Demonstrates feasibility of searching sets of information in time equal to searching a single piece. 
Demonstrates potentially unique process of searching from an origin point and a specified goal state in tandem, which is useful for discovering a traversal from a start to an end state. 

# Details
Search Criteria : Provided as a parameter -> The node whos parent node must be found. 

Relative Search Coordinate: The updated Search Criteria -Updated while searching-

Value Offset: An offset used to update the Search Criteria

Initial Search Set: This is technically the set of nodes associated with a recursive-left parse of the tree starting at the root node. 


Calculate Function:
  It parses the set of nodes defined as the recursive set of left child nodes starting at the root node. This set of nodes is the defined initial search set (Not explicitly represented in the code). This parse process performs a single calculation which represents a search of multiple sets of information. This parse is a base 2 Logarithm, and is performed against the current search value (A base 2 logarithm is used as the recursive-left set of nodes are all based on exponentiation). This calculation (Log2 +1 of current search criteria) yields the root node of a new tree to search for the criteria in. Afterwards the goal state is tested. If the numeric label of the new height variable is not equal to the relative search criteria (which initially is the provided search criteria), then a tree of height=(calculated value) is utilized, and the search criteria is updated through an offset. This offset has the effect of taking the initial/current tree (the tree is also not explicitly represented), and updating the criteria such that the relative location of the original search criteria is maintained in the new tree. This process repeats until the currently tested value (Through the logarithm calculation) is equal to the relative search criteria/coordinate. After that, a formula is used to calculate the solution, which will either be search_criteria +1 or adding an exponent to the search criteria. 
  
# Numbers
  Height: h (Utilized as number of Layers, not 0 indexed Height)
# Properties
  Root Node: Root has label 2^(h) -1
  
  Labels: some number
  
  Recursive Left Node Set: 
    Starting at root, ending at last left child
    
    left_child_label = ((cur_node_label +1 )/2)-1 
    Parent_Node_Label = ((cur_node_label + 1)*2)-1
    
  Recursive Right Node Set:
    For each Node: Recursive Right Child Parse 
    
    right_child = cur_node -1
    
    ex: right-right child of a node in this set is cur_node -1 -1. 
    
# Time Complexity

Calculate Function:

Worst: O(h) -> Ex: h=3, Val = 5 (rightmost leaf of tree) 

Avg: O(Log(h)) -> h=3, Val = 2 (Not rightmost leaf and not in initial recursive-left set) 

Best: O(1) -> Ex: h=3, Val = 3 (anything in initial recursive-left set)


# Final Thoughts

The loop is bounded by h, but has an early cutoff. So the complexity -in this case- isnt always O(h). 

And. 

There is an update to this coming later. It is O(Log(h)) worst case. 


Cheers :beer:

