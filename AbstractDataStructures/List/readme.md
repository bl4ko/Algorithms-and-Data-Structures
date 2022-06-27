# List

List is an abstract data type that **reperesents a finite number of ordered values**, where the same value may occur **more than once**.

## Operations

- `makenull(L)` - constructor for creating an empty list
- `empty(L)` - testing whether or not a list is empty
- `insert(x, p, L)` - appending entity to a list at position p
- `retrieve(p, L)` - accessing hte element at a given index p 
- `first(L)` - retrieve the first element of a list
- `last(L)` - retrieve the second element of a list
- `delete(p, L)` - deleting element at index p

## Implementations

- **ArrayList** (static field)
- **LinkedList**
    - singly
    - doubly

| Operation | Singly LinkedList | Doubly LinkedList | ArrayList |
| - | - | - | - |
| `makenull(L)` | O(1) | O(1) | O(1) |
| `first(L)` | O(1) | O(1) | O(1) |
| `last(L)` | O(1) | O(1) | O(1) |
| `next(p, L)` | O(1) | O(1) | O(1) |
| `previous(p, L)` | <u>**O(n)**</u> | O(1) | O(1) |
| `retrieve(p, L)` | O(1) | O(1) | O(1) |
| `insert(x, p, L)` | O(1) | O(1) | <u>**O(n)**</u> |
| `append(x, L)` | O(1) | O(1) | O(1) |
| `delete(p, L)` | <u>O(1) <-> O(n)</u> | O(1) | <u>O(n)</u> |
| `empty(L)` | O(1) | O(1) | O(1) |
| `end(L)` | O(1) | O(1) | O(1) |
| `overend(p, L)` | O(1) | O(1) | O(1) |
| `locate(x, L)` | **O(n)** | **O(n)** | **O(n)** |
| `printlist(L)` | **O(n)** | **O(n)** | **O(n)** |

<u>Linked list versus ArrayList</u>

| | Linked List | ArrayList |
| - | - | - |
| <kbd>Advantages</kbd> |  <li>Fast Insertion/Deletion time</li><li>Dynamic size</li><li>Efficient memory allocation/utilization</li> | <li>Fast search time (Random access)</li><li>Less memory needed per element</li><li>Better **cache** locality</li>  | 
| <kbd>Disadvantages</kbd>|  <li>Wasted memory (extra pointers)</li><li>Difficult to perform reverse traversing</li> | <li>Slow Insertion/Deletion time</li><li>Fixed size</li><li>Inefficient memory allocation/utilization</li>|
