#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
int main(void )
{
	int hijo1[2];
	int hijo2[2];
    pipe(hijo1);
    pipe(hijo2);
    int Psuma1[2];
	int Psuma2[2];
    pipe(Psuma1);
    pipe(Psuma2);
	srand(time(NULL));
    int entero;
    int fin = 0;
    int suma;
    int suma2;
    int id = fork();
	if (id == -1){
	   	return 2;   		
	} else if (id == 0){
		close(hijo1[1]); 
		while(0!=read(hijo1[0],&entero, sizeof(entero))){
			if(entero%4==0 && entero!=0){
	            printf("\tEl HIJO recibe multiplos: %d\n",entero);
	            suma=suma+entero;   	
			} 
			if (entero==0){
				//printf("\tSuma HIJO multiplos: %d\n",suma);
				close(Psuma1[0]); 
				write(Psuma1[1], &suma, sizeof(suma));
				exit(0); 
			}
        }   	
	} 
	else {
		if (fork() == 0){ 
			close(hijo2[1]);
			while(0!=read(hijo2[0], &entero, sizeof(entero))){
				if(entero%4!=0){
					printf("\tEl HIJO2 recibe normales: %d\n",entero);
					suma2=suma2+entero;
				}
				if (entero==0){
					//printf("\tSuma HIJO normales: %d\n",suma2);
					close(Psuma2[0]);
					write(Psuma2[1], &suma2, sizeof(suma2));
					exit(0);
				}
			}      	
		}
		for(int i=0;i<10;i++){
			entero=rand() % 100;
			if(entero%4==0){
				write(hijo1[1], &entero, sizeof(entero)); //escribo en pipe
				printf("El PADRE ENVIA MENSAJE AL HIJO multiplos ...%d\n", entero);
			}
			else{
				write(hijo2[1], &entero, sizeof(entero)); //escribo en pipe
				printf("El PADRE ENVIA MENSAJE AL HIJO2 normales ...%d\n",entero);
			}
		}
		write(hijo1[1], &fin, sizeof(fin));
		write(hijo2[1], &fin, sizeof(fin));
		wait(NULL);
		wait(NULL);
		close(hijo1[1]);
		close(hijo2[1]);
		close(Psuma1[1]);
		close(Psuma2[1]);
		read(Psuma1[0], &suma, sizeof(suma));
		read(Psuma2[0], &suma2, sizeof(suma2));
		printf("\tSuma FINAL MULTIPLOS: %d\n",suma);
		printf("\tSuma FINAL NORMALES: %d\n",suma2);
	}    
}