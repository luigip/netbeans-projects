
#include <iostream>

using namespace std;

struct ListNode {
    int data;
    ListNode *next; // pointer to the next node in the list
};

void PrintList(ListNode *p) {
    
    while (p != NULL) {
        cout << p->data <<endl;
        p = p->next;
    }
}

void PrintReverse(ListNode *p) {
    
    if(p->next != NULL) {
        PrintReverse(p->next);
    }
    cout << p-> data << endl;
}

int main(int argc, char** argv) {

    ListNode *head = NULL; // head points to the list of nodes, initially empty
    int k;
    while (cin >> k) {

        // create a new list node containing the value read in
        ListNode *tmp = new ListNode;
        tmp->data = k;

        // attach the new node to the front of the list
        tmp->next = head;
        head = tmp;
    }
    
    PrintList(head);
    return 0;
}

