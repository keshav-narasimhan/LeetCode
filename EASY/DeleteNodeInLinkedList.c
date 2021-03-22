#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

// Definition for singly-linked list.
 struct ListNode {
    int val;
    struct ListNode *next;
};
 
void deleteNode(struct ListNode* node) {
    
    struct ListNode *temp = node->next;
    
    // give 'node' the val of 'temp'
    node->val = temp->val;
    
    // make 'node' point to the node after 'temp'
    node->next = temp->next;
    
    // delete the 'temp' node
    temp->next = NULL;
    free(temp);
    
}
