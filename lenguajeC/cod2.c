#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void main() {
	pid_t pid, Hijo_pid;
	pid = fork ();

	if (pid == -1) // Ha ocurrido un error
	{
		printf ("No se ha podido crear el proceso hijo ... " );
		exit(-1);
	}

	if (pid == 0) //Nos encontramos en Proceso hijo
	{
		for(int i=0;i<100;i++){
            for(int k=0;k<100;k++);
            write(1, "Soy hijo", 9);     
        }
	}
	else //Nos encontramos en Proceso padre
	{
		for(int i=0;i<100;i++){
            for(int k=0;k<100;k++);
            write(1, "Soy padre", 10);    
        }
	}
	exit(0);
}
