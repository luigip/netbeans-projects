
#include <iostream>
using namespace std;

int main() {

    char * s = "Hello";
    
    cout << s << endl;  // Hello
    cout << &s << endl; // address of pointer
    cout << *s << endl; // 'H'
    cout << *(s + 4);   // 'o'
    
    return 0;
}

