#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

// Definition for singly-linked list.
struct ListNode {
    int val;
    struct ListNode *next;
 };

struct ListNode* rotateRight(struct ListNode* head, int k){

    /*
    * return 'head' if no need to rotate OR head is null OR list is just 1 element 
    */
    if (head == NULL || head->next == NULL || k == 0)
    {
        return head;
    }
    
    /*
    * local var declarations
    */
    struct ListNode *temp_head = head;
    int sum = 1;
    
    /*
    * Find last node in LL & create a cycle
    */
    while (head->next != NULL)
    {
        head = head->next;
        sum++;      // find the total num of nodes in the list
    }
    head->next = temp_head;
    
    k %= sum;       // find total num of rotations needed based on num of nodes in list
    
    for (int i = 0; i < /* rotate right */(sum - k - 1); i++)
    {
        temp_head = temp_head->next;        // loop till temp_head is the node before the new head
    }
    
    head = temp_head->next;     // define the new head
    temp_head->next = NULL;     // delete the cycle
    
    return head;
    
}