/*
 *
 *created by: rishabh
 *03-Oct-2017
 *12:29:53 AM
 */
#include <iostream>

using namespace std;

int main() {
//Todo Place code here
	string str;
	scanf("%s", &str);
	for (int i = 0; i < str.length(); i++) {
		int k = (str[i]);
		if (k > (9 - k)) {
			k = 9 - k;
			str[i] = (char) ('0' + k);
		}
	}
	int i = 0;
	for (i = 0; i < str.length(); i++) {
		if (str[i] != '0') {
			break;
		}
	}
	string m = m.substr(i);
	if (m == "") {
		printf("0");
	} else {
		printf("%s", m);
	}
	return 0;
}
//Function Definition
