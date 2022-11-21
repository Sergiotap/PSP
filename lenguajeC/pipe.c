#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
int main (void){
    int fd[2];
    pid_t pid;
    pipe(fd);
    pid=fork();
 srand (time(NULL));
    int num;
    int suma=0;
    do
    {
        num=rand()% 10;
        switch(pid) {
            case -1: 
                printf("NO SE HA PODIDO CREAR HIJO ... " );
                exit (-1);
            case 0:
                close(fd[1]);
                read(fd[0], &num, sizeof(num));
                printf("\tEl numero es : %d\n",num);
                suma+=num;
            default:
                write(fd[1], &num, sizeof(num));
                break;
        }
    } while (num!=0);
    if(suma>0){
        printf("\tLa suma es : %d\n",suma);
    return 0;
    }
    return 0;
}
