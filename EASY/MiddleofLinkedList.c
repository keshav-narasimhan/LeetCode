#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

// Definition for singly-linked list.
struct ListNode {
    int val;
    struct ListNode *next;
};


struct ListNode* middleNode(struct ListNode* head){
    
    struct ListNode *temp = head;
    int num_elems = 1;
    
    while (head->next != NULL)
    {
        num_elems++;
        head = head->next;
    }
    head = temp;
    
    for (int a = 0; a < num_elems/2; a++)
    {
        head = head->next;
    }
    
    return head;
    
}
