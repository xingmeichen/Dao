
#include<iostream>
using namespace std;
class A{
  int x, y;
public:
A() { x = 0; y = 0;}
A(int a, int b) { x = a; y = b;}
~A() {
  if (x == y) cout << "x == y"<<endl;
  else cout << "x != y" <<endl;
}
void display() {
  cout << "x=" << x << ", y="<< y <<endl;
}
};

int main() {
  A a1, a2(2,3);
  a1.display();
  a2.display();
  return 0;
}

