#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
int main()
{   
    pid_t pid;
	pid = fork ();
    pid_t pid2;
	pid2 = fork ();
    int contador, n;
    printf( "\n   " );
    if (pid == -1) // Ha ocurrido un error
	{
		printf ("No se ha podido crear el proceso hijo ... " );
		exit(-1);
	}
    if (pid==0){
        if(pid2==-1){
            printf ("No se ha podido crear el proceso hijo ... " );
		exit(-1);
        }
        else if(pid2==0){
            wait(NULL);
            imprimePrimos(100000,125000);
        }
        else{
            wait(NULL);
            imprimePrimos(125000,150000);
        }
    }
    else{
        if(pid2==-1){
            printf ("No se ha podido crear el proceso hijo ... " );
		exit(-1);
        }
        else if(pid2==0){
            wait(NULL);
            imprimePrimos(150000,175000);
        }
        else{
           wait(NULL); 
           imprimePrimos(175000,200000);
        }
    }
    return 0;
}
void imprimePrimos(int num1, int num2) {
    for (num1;num1<num2;num1++) {
            int y=2;
            for (y;y<num1;y++) {

                if (num1%y==0) {
                    break;
                }
            
            }
            if (y>=num1) {
                printf("\n primo: %d ",num1);
            }

        }

}
