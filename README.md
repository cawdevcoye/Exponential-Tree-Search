Author: Chris W
# Exponential-Tree-Search

In the field of Combinatorics, finding solutions to specific problems is usually quite complicated. There isnt a single algorithm to find a given solution to an arbitrary combinatorial problem, and as such, finding fast solutions to unique combinatorial problems require domain specific algorithms. In general, these algorithms are based on unique properties associated with a given question, where the process of building a polynomial time algorithm revolves around utilizing those properties and building a solution with them. For particularly tricky problems, the process may require finding novel properties to utilize. 

This algorithm was designed through the process of building a domain specific solution to a search problem, and is an example of a domain specific solution to a combinatorial problem. 

# Problem
Said problem formally asks for the label of the parent node of a given node in an exponential tree. The labeling description is in the document. 

# High Level Description
This solution uses a Double-Ended search algorithm based on searching from a defined start location and a defined goal location in tandem. This script also works by looking through a set of nodes at once, rather than looking at nodes individually. The tandem search process is based on redefining the search criteria while the search is taking place, and uses the deterministic changes made to the search criteria to cast a discovered solution from the redefined criteria back to the original criteria, where the full solution computation can be made. 

The consequences of this solution are as follows: Demonstrates feasility of searching sets of information in time equal to searching a single piece. Demonstrates unique process of searching from an origin point and a specified goal state in tandem. 

# Details
Calculate Function:
  It parses the set of nodes defined as the recursive set of left child nodes starting at the root node. This set of nodes is the defined initial search set. 
  
# Numbers
  Height: h
# Properties
  Root Node: Root has label 2^(h) -1
  
  Node_Label: Is some number
  
  Recusive Left Node Set: 
    Starting at root, ending at last left child
    
    left_child_label = ((cur_node_label +1 )/2)-1 
      
    
