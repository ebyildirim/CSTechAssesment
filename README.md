# CSTechAssesment

In my solution, i create doubly linkedlist without tail. It works same with queue. First in first out structure is used. The last added has the highest priority.
However, in some points we should change priority of nodes. If a value in the cache comes to the structure, we increase the priority of that value by 1.So we replace the node in the linkedlist with the previous node. in linkedlist root has highest priority and the further away from the root, the less priority. If if the length of the linkedlist is bigger than size we delete elements from last until the length and size are equal.
