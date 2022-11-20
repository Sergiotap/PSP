#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
void main (void){
    int fd[2];
    pid_t pid;
    pipe(fd);
    pid=fork();
    int num1, num2;
    int suma=0;
    switch(pid) {
        case -1: 
            printf("NO SE HA PODIDO CREAR HIJO ... " );
            exit (-1);
            break;
        case 0:
            wait(NULL);
            read(fd[0], &num1, sizeof(num1));
            read(fd[0], &num2, sizeof(num2));
            printf("\tEl numero es : %d\n",num1);
            printf("\tEl numero es : %d\n",num2);
            suma=num1+num2;
            write(fd[1], &suma, sizeof(suma));
            break;
        default:
            printf("Introduce el primer número: ");
            scanf("%d",&num1);
            write(fd[1], &num1, sizeof(num1));
            printf("Introduce el segundo número: ");
            scanf("%d",&num2);
            write(fd[1], &num2, sizeof(num2));
            wait(NULL);
            close(fd[1]);
            read(fd[0], &suma, sizeof(suma));
            printf("\tLa suma es : %d\n",suma);
            break;
    }
}
