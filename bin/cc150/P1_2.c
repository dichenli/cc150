#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
1.2 Implement a function void reverse(char* str) in 
C or C++ which reverses a null- terminated string.
*/

//这里我用了两个指针来交换，也可以用index i，j来交换，可能会更好写。
void reverse(char* str) {
	char* end;
	char t;
	
	if(str == NULL || str[0] == '\0') return ;
	
	for(end = str; *(end + 1) != '\0'; end++);
	
	//in c, two pointers can compare with each other directly, 
	//but such comparison is only valid when two pointers are at the same string/array area. 
	//So it is dangerous to do like p1 + 10 > p2 (p1 + 10 could be outside of the string field, the comparison is meaningless)
	//but p2 - p1 < 10 is fine
	while (end > str) {
		t = *end;
		*end = *str;
		*str = t;
		end--;
		str++;
	}
}

int main() {
	char a[10] = "";
	char b[10] = "abcd";
	char d[10] = {'a', 'b', '\0'};
	char* e = NULL;
	reverse(a);
	reverse(b);
	reverse(d);
	reverse(e);
	printf("%s\n%s\n%s\n%s\n", a, b, d, e);
}