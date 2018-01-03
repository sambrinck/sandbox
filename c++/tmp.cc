
#include <iostream>
#include <thread>

void print(const std::string& value) {
  std::this_thread::yield();
  std::cout << value<< std::endl;
}

int main (const int argc, const char** argv)
{
  std::thread foo([](){  print("Hello World!!!");       });
  std::thread bar([](){  print("Testing the function "); });
	
  foo.join();
  bar.join();

}

