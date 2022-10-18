
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>


void main () {
    int numero = 4;

    for (int i = 0;i < numero;i++) {
        if(i==0){
            if (fork()==0) {
                imprimePrimos(100000,125000);
                exit(0);
            }
        }
        else if(i==1){
            if (fork()==0) {
                imprimePrimos(125000,150000);
                exit(0);
            }
        }
        else if(i==2){
            if (fork()==0) {
                imprimePrimos(150000,175000);
                exit(0);
            }
        }
        else{
            if (fork()==0) {
                imprimePrimos(175000,200000);
                exit(0);
            }
        }
    }
    
    for (int i = 0;i < numero;i++ ) {
        wait(0);
    }

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
                printf("\n primai: %d ",num1);
            }

        }

}
