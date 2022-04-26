#include<iostream>
using namespace std;
int main() {
	int n;
	int select = 1;
	cin >> n;
	int maxstar =1;
	for (int p = 0; p < n-1; p++) {
		maxstar += 2;
	}
	for (int i = 0; i <= n; i++) {
		for (int j = 0; j < maxstar; j++) {
			cout << "*";
		}
		cout << endl;
		for (int z = n - i; z <= n; z++) {
			cout << " ";
		}
		maxstar -= 2;
	}

}