#include <iostream>
#include<io.h>
#include<stdio.h>


int main(int argc, char *argv[])
{
  long file;
    struct _finddata_t find;
     
   
     if((file=_findfirst("D:\wc", &find))==-1L)
  {
      printf("¿Õ°×!\n");
     exit(0);
     }
     printf("%s\n", find.name);
     while(_findnext(file, &find)==0)
     {
          printf("%s\n", find.name);
     }
     _findclose(file);
   
  system("PAUSE");
     return 0;
}