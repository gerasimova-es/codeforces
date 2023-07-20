/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>
#include <math.h>

int main ()
{
  unsigned int n;
  scanf("%d", &n);

  unsigned int[n] legs;
  for (int i = 0; i < n; i++){
    scanf("%d", &legs[i]);
  }

  unsigned int source;
  scanf("%d", &source);
  source--;

  unsigned int dest;
  scanf("%d", &dest);
  dest--;

  if (source == dest){
    printf("1\n%d", source + 1);
    return 0;
  }

  const unsigned maxLegsCount = 300000;

  bool simples[maxLegsCount];

  for (int i = 2; i * i < maxLegsCount; i++) {
    if (simples[i]) {
      for (int j = i * i; j < maxLegsCount; j += i) {
        simples[j] = false;
      }
    }
  }

  int** spiderToSimple = new int*[n];
  int** simpleToSpider = new int*[maxLegsCount];

  for (int i = 0; i < n; i++) {
    if (simples[legs[i]]) {
        spiderToSimple[i] = new int[1];
        spiderToSimple[i][0] = legs[i];

        Set<Integer> spiders = simpleToSpiders[legs[i]];
        if (spiders == null) {
          spiders = new HashSet<>();
          simpleToSpiders[legs[i]] = spiders;
        }
        spiders.add(i);
    }


  }

  //delete
  for (int i = 0; i < n; i++) {
    delete[] spiderToSimple[i];
  }
  delete[] spiderToSimple;

//  int[n] spiderToSimple[n] = new int(n);
//  int *simpleToSpider = new int(n);
//  delete[] arr;

  return 0;
}
