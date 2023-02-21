#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
void main (){
    int fd[2];
    pid_t pid;
    pipe(fd);
    pid=fork();
    int num1 = 0 , num2;
    int suma=0;
    //printf("\tEl numero es : %d\n",num1);
    //write(1,"hola 1234", 11);
    //fflush(stdout);
    //exit(0);
    switch(pid) {
        case -1: 
            printf("NO SE HA PODIDO CREAR HIJO ... " );
            //fflush(stdout);
            exit (-1);
            break;
        //Aquí el hijo
        case 0:
            //wait(NULL);
            read(fd[0], &num1, sizeof(num1));
            read(fd[0], &num2, sizeof(num2));
            printf("\tEl numero es : %d\n",num1);
            //fflush(stdout);
            printf("\tEl numero es : %d\n",num2);
            //fflush(stdout);
            suma=num1+num2;
            write(fd[1], &suma, sizeof(suma));
            break;
        //Aquí el padre
        default:
            printf("Introduce el primer número: ");
            fflush(stdout);
            //scanf("%d", &num1);
            read(0, &num1, 1);
            printf("He recibido: %d\n", num1);
            exit(0);

            //num1=2;
            //write(fd[1], &num1, sizeof(num1));
            printf("Introduce el segundo número: ");
            //fflush(stdout);
            num2=5;
            write(fd[1], &num2, sizeof(num2));
            //fflush(stdout);
            wait(NULL);
            close(fd[1]);
            read(fd[0], &suma, sizeof(suma));
            printf("\tLa suma es : %d\n",suma);
            //fflush(stdout);
            break;
    }
}
