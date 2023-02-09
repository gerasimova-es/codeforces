/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>
#include <math.h>

int main ()
{
  unsigned int count;
  scanf("%d", &count);

  long long number;

  for (int x = 0; x < count; x++){
    scanf("%lld", &number);
    if(number == 4){
        printf("YES\n");
        continue;
    }
    if(number < 4 || number % 2 == 0){
        printf("NO\n");
        continue;
    }
    double numberSqrt = sqrt(number);
    long roundNumberSqrt = round(numberSqrt);
    if(numberSqrt != roundNumberSqrt){
        printf("NO\n");
        continue;
    }
    double divider = sqrt(roundNumberSqrt);
    long roundDivider = (long) divider;
    if (divider == roundDivider) {
        printf("NO\n");
        continue;
    }

    int found = 0;
    for (long i = 3; i <= roundDivider; i = i + 2) {
        if (number % i == 0) {
            found = 1;
            break;
        }
    }
    if(found == 1){
        printf("NO\n");
    } else {
        printf("YES\n");
    }
  }
  return 0;
}