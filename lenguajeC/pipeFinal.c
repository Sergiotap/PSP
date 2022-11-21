#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <signal.h>
void sighandler(int);
int main (void){
    int fd[2];
    pid_t pid;
    pipe(fd);
    pid=fork();
 srand (time(NULL));
    int num;
    int suma=0;
        switch(pid) {
            case -1: 
                printf("NO SE HA PODIDO CREAR HIJO ... " );
                exit (-1);
            case 0:
                do{
                    num=rand()% 10;
                    printf("Se ha enviado el número %d desde el hijo\n",num);
                    write(fd[1], &num, sizeof(num));
                }
                while(1);
            default:
                do{
                    close(fd[1]);
                    read(fd[0], &num, sizeof(num));
                    printf("Se ha recibido el número %d en el padre\n",num);
                    suma+=num;
                }while(num!=0);
                kill(pid,9);
                printf("I killed my son\n");
                printf("\tLa suma es : %d\n",suma);
            break;
        }
    return 0;
}
